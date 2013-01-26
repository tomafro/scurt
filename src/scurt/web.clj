(ns scurt.web
  (:require [scurt.web.links :as links])
  (:use [compojure.core :only [defroutes ANY]]))

(defroutes routes
  (ANY "*" [] links/routes))