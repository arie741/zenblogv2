(ns zenblogv2.routes
  (:require [compojure.core :refer :all]
            [zenblogv2.layout :as page]
            [zenblogv2.pageandctrl.ctrl :as pages]))



(defroutes home
  (GET "/" req
       (pages/homepage)))