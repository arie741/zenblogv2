(ns zenblogv2.pageandctrl.ctrl
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]
            [zenblogv2.pageandctrl.homepage :refer :all]
            [zenblogv2.pageandctrl.homepagehot :as hot]
            [zenblogv2.pageandctrl.homepagefresh :as fresh]
            [zenblogv2.pageandctrl.postblog :refer :all]
            [zenblogv2.pageandctrl.blogpage :refer :all]
            [zenblogv2.pageandctrl.homesearch :as homesea]))

;;Pages

(def ctitle " - zenius.net | The next revolution in learning")

;;postblog
(defn postpage [anti-forgery-token]
  (createpage #(postb anti-forgery-token) (str "Post" ctitle)))

;;homepage
(defn homepage []
  (createpage home (str "Home" ctitle)))

;;blogpage
(defn blogpage [id]
  (createpage #(blogp id) (str "Blog" ctitle)))

;;homepagehot
(defn homepagehot []
  (createpage hot/homehot (str "Home" ctitle)))

;;homepagefresh
(defn homepagefresh []
  (createpage fresh/homefresh (str "Home" ctitle)))

;;homesearch
(defn homesea [sword]
  (createpage #(homesea/homesea sword) (str "Search Result : " (str (homesea/countresult sword)) ctitle)))