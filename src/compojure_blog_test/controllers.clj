(ns compojure-blog-test.controllers
  (:require [ring.util.response :as resp]
            [compojure-blog-test.views.render-post :as views]
            [compojure-blog-test.data.access :as db]))

(defn landing-page []
  "hello world")

(defn post-by-id-or-404 [id]
  (let [post (db/post-by-id id)]
    (cond
     (empty? post) (resp/not-found (str "The post for " id " was not found"))
     :else (views/render-post post))))
