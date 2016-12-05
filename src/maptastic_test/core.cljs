(ns maptastic-test.core
  (:require [maptastic]))

(defn start []
  (let [container-a (.getElementById js/document "containerA")
        container-b (.getElementById js/document "containerB")

        map-config (clj->js {:autoSave false
                             :autoLoad false
                             :onReload (fn [] ((.log js/console (js/Maptastic.getLayout.))))
                             :layers [container-a container-b]})]
  (js/Maptastic map-config)))
