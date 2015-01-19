(ns zenblogv2.pageandctrl.ctrl
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]
            [zenblogv2.pageandctrl.homepage :refer :all] ))

;;Pages

(def ctitle " - zenius.net | The next revolution in learning")

;;homepage
(defn homepage []
  (createpage home (str "Home" ctitle)))

