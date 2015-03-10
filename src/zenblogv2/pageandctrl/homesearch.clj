(ns zenblogv2.pageandctrl.homesearch
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]))

(defn countresult
  "This count the number of search shown on the page"
  [sword]
  (count (db/search-by-title sword)))

(defn sr
  "This creates a h4 'Search results:'"
  [sword]
  (hc/html 
    [:h4 (str "Search Result : " (str (countresult sword)))]
    [:br]))

(defn blog
  "This creates a html template for the blogs you see at the homepage"
  [kjudul kisi kid]
  (hc/html [:div {:class "panel"}
            "\n    " [:h2 kjudul] "\n    "
            [:p kisi "... "
             [:a {:href (str "/blog/" kid)} "Baca Selengkapnya"]]]))

(html/deftemplate homesea "selmer/home.html"
  [sword]
  [:blogtemplate] (html/html-content
                    (str (apply str (sr sword))
                    (apply str (map #(blog (:key %) (take 500 (:value %)) (:id %)) 
                                    (db/search-by-title sword))))))


;;ghfufyjryuasdadasdas

