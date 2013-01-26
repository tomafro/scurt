(defproject scurt "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :main scurt.main
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.2.0"]
                 [ring/ring-jetty-adapter "0.3.9"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [korma "0.3.0-beta7"]
                 [compojure "0.6.4"]
                 [enlive "1.0.1"]
                 [ring-basic-authentication "1.0.1"]]
  :dev-dependencies [[midje "1.4.0"]
                     [com.stuartsierra/lazytest "1.2.3"]])