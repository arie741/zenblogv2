(ns zenblogv2.pageandctrl.blogpage
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))


(html/deftemplate blogp "selmer/blogpage.html"
  [id]
  [:bjudul] (html/content (:title (db/find-by-id id)))
  [:bisi] (html/content (:isi (db/find-by-id id))))

;;;


