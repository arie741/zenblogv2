(ns zenblogv2.pageandctrl.postblog
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))


(defn post
  "This funcion creates a new document on cloudant in the database 'zenblog'"
  [judul isi] 
  (->> {:title judul :isi isi :rating 0 :date (db/indo-time-now)}
       (cl/put-document db/db)))

(html/deftemplate postb "selmer/postblog.html"
  [anti-forgery-token]
  [:anti-forgery-field] (html/html-content (hc/html [:input {:id "__anti-forgery-token"
                                                        :name "__anti-forgery-token"
                                                        :type "hidden"
                                                        :value anti-forgery-token}])))