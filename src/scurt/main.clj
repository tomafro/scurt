(ns scurt.main
  (:require [compojure.handler :as handler])
  (:use [ring.adapter.jetty :only [run-jetty]]
        [scurt.web :only [routes]]))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (run-jetty (handler/api routes) {:port port})))

