(ns scurt.web.links
  (:require [clojure.data.json :as json])
  (:use [compojure.core :only [defroutes GET POST PUT DELETE ANY]]
        scurt.models.link
        ring.middleware.basic-authentication))

(defn authenticated? [name pass] (and (= name (System/getenv "AUTH_USER")) (= pass (System/getenv "AUTH_PASSWORD"))))

(defn create [{:keys [url]}]
  (if-let
    [link (find-link-by-url url)]
          {:status 200 :headers {"Location" (:uri link)}}
          {:status 201 :headers {"Location" (:uri (create-link url))}}))

(defn show [key]
  (if-let [link (find-link-by-key key)]
          {:status 302 :headers {"Location" (:location link)}}
          {:status 404}))

(defn json-index []
  {:status 302
   :headers {"Content-type" "application/json"}
   :body (json/write-str (find-all) :escape-unicode false)})

(defroutes admin-routes*
  (POST "/l" {params :params} (create params)))

(def admin-routes
  (wrap-basic-authentication admin-routes* authenticated?))

(defroutes public-routes
  (GET "/l" [] (json-index))
  (GET "/:key" [key] (show key)))

(defroutes routes
  (ANY "*" [] public-routes)
  (ANY "*" [] admin-routes))