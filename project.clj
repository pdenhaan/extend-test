(defproject extend-test "0.1.0-SNAPSHOT"
  :description "Extend error test"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler extend-test.core.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :aliases {"war!" ["ring" "uberwar" "extend-test.war"]
            "web!" ["ring" "server-headless"]})
