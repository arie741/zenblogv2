(ns zenblogv2.routes
  (:require [compojure.core :refer :all]
            [zenblogv2.layout :as page]
            [zenblogv2.pageandctrl.ctrl :as pages]
            [zenblogv2.pageandctrl.postblog :as post]
            [noir.response :as resp]))


(defroutes home
  (GET "/" req
       (pages/homepage))
  (GET "/search" req
        (pages/homesea (:q (:params req))))
  (GET "/hot" req
       (pages/homepagehot))
  (GET "/fresh" req
       (pages/homepagefresh))
  (GET "/post" req
       (pages/postpage
        (:ring.middleware.anti-forgery/anti-forgery-token
         (:session req))))
  (POST "/action-post" req
        (let [bjudul (:judul (:params req))
              bisi (:isi (:params req))]
          (do (post/post bjudul bisi) 
              (resp/redirect "/"))))
  (GET "/blog/:blogid" [blogid]
       (pages/blogpage blogid)))

;;;;;;
