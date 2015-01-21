(ns zenblogv2.pageandctrl.homepage
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn blog
  "It would be nice if you tell others what this function does"
  [kjudul kisi kid]
  (hc/html [:div {:class "panel"}
            "\n    " [:h2 kjudul] "\n    "
            [:p kisi "... "
             [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(html/deftemplate home "selmer/home.html"
  []
  [:blogtemplate] 
  ;; This kind of thing is the one suitable using clojure's threading macro of ->> or ->
  (html/html-content (apply str 
                            (map #(blog (:key %) (take 500 (:value %)) (:id %)) 
                                 (db/get-by-title)))))
                               
                

