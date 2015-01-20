(ns zenblogv2.pageandctrl.postblog
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn post [judul isi]
  (cl/put-document db/db {:title judul :isi isi :rating 0}))

(html/deftemplate postb "selmer/postblog.html"
  [])

