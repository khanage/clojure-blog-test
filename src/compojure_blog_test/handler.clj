(ns compojure-blog-test.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure-blog-test.views :as views]))

(defroutes app-routes
  (GET "/" [] "Hello World")

  (GET "/:id" [id] (views/render-blog id))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
