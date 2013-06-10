(ns lobos.config
  (:use lobos.connectivity)
  (:require [compojure-blog-test.data.db :as cbt]))

(open-global cbt/dbspec)
