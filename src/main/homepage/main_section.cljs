(ns homepage.main-section
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]))

(def points
  [(d/p "I used ClojureScript to generate this site")
   (d/p "Started with a barebones shadow-cljs project using "
        (d/code "create-cljs-project"))
   (d/p "Added Helix as a React wrapper")
   (d/p "created a couple of components, and hooks for side effects")])

(defn point->li
  [point i]
  (d/li
   {:key i
    :style {:font-size "x-large"
            :font-weight 100
            :margin-bottom "1rem"}}
   point))

(defnc main-section
  []
  (d/main
   (d/ul (map point->li
              points
              (range (count points))))))
