(ns compojure-blog-test.data.access
  (:use korma.core korma.db compojure-blog-test.data.db))

(defdb blog-db dbspec)
