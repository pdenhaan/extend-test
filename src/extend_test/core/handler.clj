(ns extend-test.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defrecord FooRecord [msg])

(defprotocol FooProtocol
  (bar [foo] "to use with extend-type"))

(extend FooRecord
  FooProtocol
  {:bar (fn [foo] (str "Test " (:msg foo)))})

(defroutes app-routes
  (GET "/" [] (bar (->FooRecord "Successful")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
