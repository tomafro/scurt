(ns scurt.db
  (:use [korma.db]))

(def db-config
  (let [db-uri (bean (java.net.URI/create (System/getenv "DATABASE_URL")))
       [user password] (clojure.string/split (or (:userInfo db-uri) ":") #"\:")
        db (apply str (drop 1 (:path db-uri)))]
    (conj {:user user :password password :db db} (select-keys db-uri [:host :port]))))

(defdb db (postgres db-config))
