(ns zenblogv2.pageandctrl.homepagehot
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]
            [zenblogv2.pageandctrl.homepage :as hp]))

(html/deftemplate homehot "selmer/home.html"
  []
  [:blogtemplate]
  ;; And this is an example of using thread-last macro ->>
  (->> (db/sort-by-rating)
       (map #(hp/blog (:title %) (take 500 (:isi %)) (:_id %)))
       (apply str)
       (html/html-content)))

