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

;;search engine
(defn string-splitter [strings] 
  (map #(apply str %) (remove #(= \space (first %)) (partition-by #(= \space %) strings))))

(defn cart [colls]
  (if (empty? colls)
    '(())
    (for [x (first colls)
          more (cart (rest colls))]
      (cons x more))))

(defn string-matcher [strone strtwo]
  (count (filter true? (map #(apply = %) (cart (list (string-splitter (clojure.string/upper-case strone)) (string-splitter (clojure.string/upper-case strtwo))))))))

(defn search-matches [string]
  (filter #(> (string-matcher string (:key %)) 0) (get-by-title)))

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
