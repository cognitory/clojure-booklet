(ns cognitory.booklet.core
  (:require 
    [clojure.string :as string]
    [cljsjs.codemirror]
    [cljsjs.codemirror.mode.clojure]
    [markdown.core :refer [md->html]]
    [zprint.core :refer [zprint zprint-str]]
    [reagent.core :as r]
    [cognitory.booklet.styles :refer [styles-view]]
    [cognitory.booklet.data :refer [chapters]]))

(defn format-code [code]
  (if (nil? code)
    "nil"
    (zprint-str code 50 {:style :community
                         :binding {:force-nl? true}
                         :parse-string? (string? code)
                         :map {:comma? false
                               :force-nl? true}
                         :fn-map {"if" :arg1-force-nl
                                  "when" :arg1-force-nl
                                  "fn" :binding}})))

(defn code-view [code class-name]
  [:div {:class (string/join " "  ["CodeMirror" "cm-s-default" class-name])
         :ref (fn [el]
                (when (not (nil? el))
                  (js/CodeMirror.runMode
                    (format-code code)
                    "clojure"
                    el)))}])

(defn pre-process-text [text special-keys]
  (let [special-keys (-> special-keys
                         seq
                         (->>
                           (remove nil?)
                           (map str)
                           ; remove regex special characters
                           (map (fn [s]
                                  (string/replace s #"\(|\)|\]|\[" "")))
                           (map (fn [s]
                                  (string/split s " "))))
                         flatten
                         (concat ["nil" "false" "true"
                                  "x" "xs" "y" "ys"
                                  "f" "coll" "val"
                                  "k" "ks" "v"])
                         ; remove duplicates
                         set
                         ; remove regex special characters
                         (disj "&")
                         (disj "+")
                         (disj "*")
                         ; sort by descending length
                         ; so that longer matches are preferred to shorter matches
                         (->> (sort-by count))
                         reverse)
        key-pattern (re-pattern
                      (str "(?!`+)\\b("
                           (string/join "|" special-keys)
                           ")\\b(?!`+)"))]
    (when (seq text)
      (-> text
          #_(string/replace #"(\((.?)+\))" "`$1`")
          (string/replace #"(:[a-z]+)" "`$1`")
          (string/replace key-pattern "`$1`")))))

(defn convert-text [text]
  [:div 
   {:dangerously-set-inner-HTML 
    {:__html 
     (md->html text)}}])

(defn use-cases-view [use-cases]
  (when use-cases
    [:div.uses
     [:h2 "Use Cases"]
     (into [:ul] 
           (for [use-case use-cases]
             [:li (convert-text use-case)]))]))

(defn notes-view [notes]
  (when notes
    [:div.notes
     [:h2 "Notes"]
     (into [:ul] 
           (for [note notes]
             [:li (convert-text note)]))]))

(defn examples-view [examples]
  (when (seq examples)
    [:div.examples
     [:h2 "Examples"]
     (into [:div.examples]
           (for [example examples]
             [:div.example
              (when (contains? example :in)
                [code-view (example :in) "in"])
              (when (contains? example :out)
                [code-view (example :out) "out"])]))]))


(defn arglists [function]
  (let [meta (meta (function :name))]
    (or (get meta :arglists)
        (get-in meta [:top-fn :arglists])
        (get function :arglists)
        [])))

(defn special-keys
  "Returns array of symbols mentioned in invocations of a function"
  [function]
  (conj (set (flatten (arglists function)))
        (or (:name (meta (function :name)))
            (:name function))))

(defn function-header-view [function]
  (into [:h1]
    (for [arglist (reverse (arglists function))]
      [:code.invocation
       [:span "("]
       [:span.name (or (:name (meta (function :name))) (:name function))]
       (when (seq arglist)
         [:span.args
          " "
          (string/join " " arglist)])
       [:span ")"]])))

(defn concept-view [concept]
  (cond
    (contains? #{:function :special-form :refer-to} (concept :type))
    (let [function concept
          meta (meta (function :name))]

      [:div.concept.function
       [function-header-view function]

       [:div.content
        [:div.explanation
         (convert-text 
           (pre-process-text (or (function :explanation)
                                 (:doc meta))
                             (special-keys function)))]

        [notes-view (function :notes)]
        [use-cases-view (function :uses)]
        [examples-view (function :examples)]]])

    :else
    [:div.concept
     [:h1 (concept :name)]
     [:div.content
      [:div.explanation
       (convert-text 
         (concept :explanation))]
      [notes-view (concept :notes)]
      [use-cases-view (concept :uses)]
      [examples-view (concept :examples)]]]))

(defn chapter-view [chapter]
  [:div.chapter
   [:h1 (chapter :title)]
   (into [:div.sections]
         (for [section (chapter :sections)]
           [:div.section
            [:h2
             [:span.chapter (chapter :title)]
             [:span.divider " | "]
             [:span.section (section :name)]]
            (into [:div.concepts]
                  (for [concept (section :concepts)]
                    [concept-view concept]))]))])

(defn summary-view [chapters]
  (into [:div.summary] 
        (for [chapter (remove :skip-index? chapters)]
          [:div.chapter
           [:h1 (chapter :title)]
           (into [:div.sections]
                 (for [section (remove :skip-index? (chapter :sections))]
                   [:div.section
                    [:h2 (section :name)]
                    (into [:div.concepts]
                          (for [concept (remove :skip-index? (section :concepts))]
                            [:div.concept {:class (name (concept :type))}
                             (or (:name (meta (concept :name)))
                                (concept :name))]))]))])))

(defn app-view []
  [:div.app
   [styles-view]
   [summary-view chapters]
   (into [:div.chapters]
         (for [chapter chapters]
           [chapter-view chapter]))])

(defn render []
  (r/render-component [app-view] (.. js/document (getElementById "app"))))

(defn ^:export init []
  (render))

(defn ^:export reload []
  (render))
