(ns zenblogv2.pageandctrl.homepagehot
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn blog
  "What is this function do?"
  [kjudul kisi kid]
  ;; And this is how you indent hiccup
  (hc/html [:div {:class "panel"}
            "\n    "
            [:h2 kjudul]
            "\n    "
            [:p kisi "... "
             [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(html/deftemplate homehot "selmer/home.html"
  []
  [:blogtemplate]
  ;; And this is an example of using thread-last macro ->>
  (->> (db/sort-by-rating)
       (map #(blog (:title %) (take 500 (:isi %)) (:id %)))
       (apply str)
       (html/html-content)))

