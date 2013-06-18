(ns compojure-blog-test.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure-blog-test.controllers :as ctr]))

(defroutes app-routes
  (GET "/" [] (ctr/landing-page))
  (GET "/post/:id" [id] (ctr/post-by-id-or-404 (Integer/parseInt id)))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
