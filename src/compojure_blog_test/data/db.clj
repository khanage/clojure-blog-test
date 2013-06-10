(ns compojure-blog-test.data.db)

(def dbspec
  (let [host "localhost", port "5432", db "compojure-blog-test"]
   {:classname "org.postgresql.Driver"
    :subprotocol "postgresql"
    :subname (str "//" host ":" port "/" db)
    :user "blog"
    :password "blog"}))
