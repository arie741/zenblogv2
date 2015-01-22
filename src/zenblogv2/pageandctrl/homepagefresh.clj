(ns zenblogv2.pageandctrl.homepagefresh
  "What is this namespace does???"
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn blog
  "Use a docstring here please!"
  [kjudul kisi kid]
  (hc/html
   [:div {:class "panel"}
    "\n    "
    [:h2 kjudul]
    "\n    "
    [:p kisi "... "
     [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(html/deftemplate homefresh "selmer/home.html"
  []
  [:blogtemplate]
  (->> (db/sort-by-date)
       (map #(blog (:title %) (take 500 (:isi %)) (:id %)))
       (apply str)
       (html/html-content)))



