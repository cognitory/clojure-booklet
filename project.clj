(defproject cognitory.booklet "0.5.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.518"]
                 [cljsjs/codemirror "5.24.0-1"]
                 [markdown-clj "0.9.99"]
                 [reagent "0.6.1"]
                 [garden "1.3.2"]
                 [zprint "0.3.2"]]

  :plugins [[lein-figwheel "0.5.10"]]

  :cljsbuild {:builds
              [{:id "dev"
                :figwheel {:on-jsload "cognitory.booklet.core/reload"}
                :source-paths ["src"]
                :compiler {:main cognitory.booklet.core
                           :asset-path "/js/dev" 
                           :output-to "resources/public/js/booklet.js"
                           :output-dir "resources/public/js/dev" 
                           :verbose true}}]})
