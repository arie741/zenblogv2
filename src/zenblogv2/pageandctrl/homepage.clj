(ns zenblogv2.pageandctrl.homepage
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn blog
  "This creates a html template for the blogs you see at the homepage"
  [kjudul kisi kid]
  (hc/html [:div {:class "panel"}
            "\n    " [:h2 kjudul] "\n    "
            [:p kisi "... "
             [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(html/deftemplate home "selmer/home.html"
  []
  [:blogtemplate] (html/html-content
                    (apply str (map #(blog (:title %) (take 500 (:isi %)) (:_id %)) 
                                    (db/sort-by-rating)))))

;;ghfufyjryuasdadasdas

