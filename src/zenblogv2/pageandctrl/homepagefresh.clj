(ns zenblogv2.pageandctrl.homepagefresh
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]
            [zenblogv2.pageandctrl.homepage :as hp]))

(html/deftemplate homefresh "selmer/home.html"
  []
  [:blogtemplate] (html/html-content (apply str (map #(hp/blog (:title %) (take 500 (:isi %)) (:_id %)) (db/sort-by-date)))))

