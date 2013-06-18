(ns compojure-blog-test.views.landing-page
  (:require [net.cgrand.enlive-html :as html]))

(def ^:dynamic *html* "compojure_blog_test/views/landing_page.html")

(html/deftemplate landing-page *html*
  [blogs]
    [:h1] (html/content "Blogs")
    [:li.post] (html/clone-for [m blogs]
                           [:h2] (html/content (:title m))
                           [:h5] (html/content (:created_on m))
                           [:p] (html/content (:content m))
                           [:a] (html/do->
                                 (html/set-attr :href (str "/post/" (:id m))))))
