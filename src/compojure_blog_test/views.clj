(ns compojure-blog-test.views)

(defn render-post [post]
  (str "This is blog entry " (:id post)))
