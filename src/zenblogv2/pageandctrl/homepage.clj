(ns zenblogv2.pageandctrl.homepage
  (:require [net.cgrand.enlive-html :as html]
            [zenblogv2.pageandctrl.pagelayout :refer :all]
            [com.ashafa.clutch :as cl]
            [zenblogv2.dbase :as db]
            [hiccup.core :as hc]
            ))

(html/deftemplate home "selmer/home.html"
  []
  )