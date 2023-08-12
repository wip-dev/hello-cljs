(ns homepage.title-section
  (:require [helix.core :refer [defnc]]
            [helix.hooks :as hooks]
            [helix.dom :as d]))

(defn format-date
  [date]
  (.toLocaleTimeString date))

(defnc title-section
  []
  (let [[time set-time] (hooks/use-state (new js/Date))]
    (hooks/use-effect
      :once
      (let [interval (js/setInterval #(set-time (new js/Date)) 1000)]
        #(js/clearInterval interval)))
    (d/aside
     {:style {:text-align "center"}}
     (d/h1
       {:style {:font-size "xxx-large"
                :font-weight 600}}
       "Hello ClojureScript!")
     (d/h2
       {:style {:font-size "xx-large"
                :font-weight 100}}
       (format-date time)))))

