(ns zenblogv2.dbase
  (:require [cemerick.url :as curl]
            [com.ashafa.clutch :as cl]
            [clj-time.core :as t]
            [clj-time.format :as f]))

(def db (assoc (curl/url "https://jaquelton.cloudant.com/" "zenblog")
          :username "henessitioulsookereduche"
          :password "nKxH7EM6Kh1eca4LYkTSphbM"))

(defn get-by-title []
  (cl/get-view db "title" "title"))

(defn find-by-id [id]
  (cl/get-document db id))

(defn view-by-rating []
  (cl/get-view db "rating" "rating"))

(defn sort-by-rating []
  (map #(find-by-id (:id %)) (reverse (sort-by :key (view-by-rating)))))

;;time
(def indonesia-time (f/formatter "HH-mm-ss-dd-MM-yyyy"))

(defmacro indo-time-now []
  (str (f/unparse indonesia-time (t/now))))

(defmacro parsed-indo-time [a]
  (f/parse indonesia-time a))

(defn interval [a]
  (t/in-seconds (t/interval (f/parse indonesia-time a) (t/now))))

(defn view-by-date []
  (cl/get-view db "date" "date"))

(defn sort-by-date []
  (map #(find-by-id (:id %)) (sort-by #(interval (:key %)) (view-by-date))))
