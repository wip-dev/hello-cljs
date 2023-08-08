(ns homepage.app
  (:require [helix.core :refer [defnc $]]
            [helix.dom :as d]
            [helix.hooks :refer [use-effect]]
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
   (use-effect :once (set! (.-title js/document) "Hello ClojureScript!"))
   ($ title-section)
   ($ main-section)))

;; start your app with your favorite React renderer
(defonce root (rdom/createRoot (js/document.getElementById "app")))
(.render root ($ app))
