(ns scurt.web
  (:require [compojure.handler :as handler]
            [scurt.web.links :as links])
  (:use [compojure.core :only [defroutes ANY]]))

(def server
  (handler/api links/routes)
  (handler/api links/admin-routes))
