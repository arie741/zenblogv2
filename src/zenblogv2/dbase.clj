(ns zenblogv2.dbase
  (:require [cemerick.url :as curl]
            [com.ashafa.clutch :as cl]))

(def db (assoc (curl/url "https://arie741.cloudant.com/" "zenblog")
          :username "arie741"
          :password "arie7412335"))

(defn get-by-title []
  (cl/get-view db "title" "title"))