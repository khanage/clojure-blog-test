(ns compojure-blog-test.controllers
  (:require [ring.util.response :as resp]
            [compojure-blog-test.views.render-post :as rp]
            [compojure-blog-test.data.access :as db]
            [compojure-blog-test.views.landing-page :as lp]))

(defn landing-page []
  (let [blogs (db/top-n-posts 5)]
   (lp/landing-page blogs)))

(defn post-by-id-or-404 [id]
  (let [post (db/post-by-id id)]
    (cond
     (empty? post) (resp/not-found (str "The post for " id " was not found"))
     :else (rp/render-post post))))

(comment

  (def blogs 
    [   
     {:id "1"
      :title "Heading"
      :created_on "About a week ago"
      :content "Replaced content"}
     {:id "2"
      :title "Another"
      :created_on "About a month ago"
      :content "Some more content"}])
)
