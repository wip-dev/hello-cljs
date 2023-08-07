(ns homepage.app
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]
            ["react-dom/client" :as rdom]
            [homepage.title-section :refer [title-section]]
            [homepage.main-section :refer [main-section]]))

(defnc app []
  (d/div
   {:style {:height "100vh"
            :padding "50px"
            :display "grid"
            :grid-template-columns "1fr 1fr"
            :align-items "center"}}
   ($ title-section)
   ($ main-section)))

;; start your app with your favorite React renderer
(defonce root (rdom/createRoot (js/document.getElementById "app")))
(.render root ($ app))
