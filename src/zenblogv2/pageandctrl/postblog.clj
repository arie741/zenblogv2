(ns zenblogv2.pageandctrl.postblog
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))


(defn post
  "Please make a habit of writing a docstring"
  [judul isi] 
  (->> {:title judul :isi isi :rating 0 :date (db/indo-time-now)}
       (cl/put-document db/db)))

(html/deftemplate postb "selmer/postblog.html"
  []
  )
