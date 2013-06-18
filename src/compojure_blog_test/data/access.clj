(ns compojure-blog-test.data.access
  (:use korma.core korma.db compojure-blog-test.data.db))

(defdb blog-db dbspec)

(declare users posts comments)

(defentity users
  (pk :id)

  (entity-fields :id :name :email :created_on :updated_on)

  (has-many comments)
  (has-many posts))

(defentity posts
  (belongs-to users { :fk :user_id })
  (has-many comments)
  (entity-fields :id :title :content :created_on :updated_on))

(defentity comments
  (belongs-to users { :fk :user_id })
  (belongs-to posts { :fk :post_id })
  (entity-fields :id :content :user_id :post_id :created_on :updated_on))

(defn top-n-posts [n]
  (-> (select* posts)
      (order :id :ASC)
      (limit n)
      (exec)))

(defn post-by-id [id]
    (select posts
          (with users)
          (with comments)
          (where { :id id })))
