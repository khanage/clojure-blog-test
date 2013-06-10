(defproject compojure-blog-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [postgresql-9.2 "1002.jdbc4"]
                 [korma "0.3.0-RC5"]
                 [lobos "1.0.0-beta1"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler compojure-blog-test.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
