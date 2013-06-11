(ns compojure-blog-test.views.render-post)

(defn render-post [post]
  (str "This is blog entry " (:id post)))
