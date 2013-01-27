(ns scurt.models.link
  (:require [clojure.java.jdbc :as sql]
            [tomafro.random :as random])
  (:use [scurt.db :only [db]]
        [korma.db]
        [korma.core]))

(defn link-hash [link-from-db]
  (if link-from-db
    {:uri (str "http://tomaf.ro/" (:key link-from-db)) :location (:url link-from-db)}))

(defentity links)

(defn create-link [url]
  (let [key (random/base36 5)]
    (insert links (values {:url url :key key}))
    (link-hash {:url url :key key})))

(defn find-first [conditions]
  (first
    (select links (where conditions) (limit 1))))

(defn find-all []
  (map link-hash (select links)))

(defn find-link-by-url [url]
  (link-hash (find-first {:url url})))

(defn find-link-by-key [key]
  (link-hash (find-first {:key key})))