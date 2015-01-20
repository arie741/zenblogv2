(ns zenblogv2.dbase
  (:require [cemerick.url :as curl]
            [com.ashafa.clutch :as cl]))

(def db (assoc (curl/url "https://jaquelton.cloudant.com/" "zenblog")
          :username "jaquelton"
          :password "sarcasm7412335"))

(defn get-by-title []
  (cl/get-view db "title" "title"))

(defn find-by-id [id]
  (cl/get-document db id))