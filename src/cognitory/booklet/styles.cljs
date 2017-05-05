(ns cognitory.booklet.styles
  (:require 
    [garden.core :refer [css]]
    [garden.stylesheet :refer [at-import at-media]]))

(def codemirror
  {:white-space "pre"
   :height "inherit"
   :font-family "Source Code Pro"
   :font-size "0.8em"
   :width "100%"
   :box-sizing "border-box"
   :padding "0.5em"})

(defn app-styles []
  [:.app
   {:font-family "Alegreya"}

   [:>.summary
    {:line-height "1.75"
     :margin-bottom "4em"}

    [:>.chapter
     {:width "50%"
      :display "inline-block"
      :box-sizing "border-box"
      :vertical-align "top"}

     ["&:nth-child(odd)"
      {:padding-right "1em"}]

     ["&:nth-child(even)"
      {:padding-left "1em"}]

     [:>h1
      {:margin "1.5em 0 0.25em"}]

     [:>.sections

      [:>.section
       {:margin "0.5em 0"
        :display "flex"
        :align-items "flex-start"}

       [:>h2
        {:font-size "0.75em"
         :margin 0
         :color "#bbb"
         :width "6.5em"
         :min-width "6.5em"
         :padding "0.3rem 0.5em 0 0"
         :text-transform "uppercase"
         :letter-spacing "0.05em"}]

       [:>.concepts

        [:>.concept
         {:display "inline-block"
          :font-family "Source Code Pro"
          :font-size "1em"
          :margin "0 0.35em"}

         [:&.refer-to
          {:color "#999"}]]]]]]]
    
   [:>.chapters

    [:>.chapter
     {:page-break-before "always"}

     [:>h1
      {:font-size "3em"
       :margin-top 0
       :border-bottom "2px solid #000000"}]

     [:>.sections

      [:>.section
       {:page-break-inside "avoid"}

       [:>h2
        {:text-transform "uppercase"
         :letter-spacing "0.05em"
         :margin-bottom "2em"}

        [:>.chapter
         {:color "#CCC"}]

        [:>.divider
         {:color "#CCC"}]

        [:>.section]]

       [:>.concepts
        {:margin-left "4em"}

        [:>.concept
         {:page-break-inside "avoid"
          :padding-bottom "4em"}

         [:>h1
          {:font-size "1.5em"
           :padding "0.5em"
           :margin 0
           :font-family "Source Code Pro"}

          [:>.invocation
           codemirror
           {:width "inherit"
            :display "inline-block"}

           [:&:first-child
            [:>span
             {:color "#CCC"}

             [:&.name
              {:color "#000"}]]]

           [:>span
            {:color "#CCC"}]]]

         [:&.function
          [:>h1
           {:padding 0}]] ; padding already in code block


         [:>.content
          {:margin-left "3em"}


          [:>.explanation
           [:code
            {:font-family "Source Code Pro"
             :font-size "0.8em"}]]

          [:>.notes
           :>.uses
           :>.examples
           {:margin-top "2em"
            :display "flex"}

           [:>h2
            {:font-size "0.8em"
             :color "#CCC"
             :letter-spacing "0.1em"
             :text-transform "uppercase"
             :margin-top "0.25rem"
             :flex-shrink 0
             :width "10em"}]]

          [:>.notes
           :>.uses

           [:>ul
            {:margin 0
             :padding-left 0
             :list-style-type "square"}

            [:>li
             {:color "#ccc"}

             [:>div
              {:color "#000"}

              [:p
               {:margin "0 0 0.5rem 0"}]]]]

           [:code
            {:font-family "Source Code Pro"
             :font-size "0.8em"
             :padding "0 0.25em"}]]

          [:>.examples

           [:>.examples

            [:>.example
             {:border "1px solid #ccc"
              :display "inline-block"
              :margin-right "2em"
              :margin-bottom "2em"
              :vertical-align "top"}

             [:>.in
              codemirror]

             [:>.out
              codemirror
              {:border-top "1px solid #eeeeee"
               :background "#fafafa"}]]]]]]]]]]]]) 

(defn styles-view []
  [:style
   {:type "text/css"
    :dangerouslySetInnerHTML
    {:__html (css
               {:auto-prefix #{:transition
                               :flex-direction
                               :flex-shrink
                               :align-items
                               :animation
                               :flex-grow}
                :vendors ["webkit"]}
               (at-import 
                "https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.20.0/codemirror.css")
               (at-import "https://fonts.googleapis.com/css?family=Alegreya|Source+Code+Pro")
              #_(at-import "https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.20.0/theme/railscasts.min.css")
               (app-styles)

               (at-media {:print true}
                 ["@page"
                  {:size "132mm 170mm"}
                  #_{:size "landscape"
                     :column-count 2}]

                 [:.chapters
                  [:>.chapter]]))}}])
                   ;{:columns 2}]]))}}])
                    ;:width "40%"}]]))}}])
