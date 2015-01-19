(ns zenblogv2.dbase
  (:require [cemerick.url :as curl]))

(def db (assoc (curl/url "https://arie741.cloudant.com/" "zenblog")
          :username "arie741"
          :password "arie7412335"))




