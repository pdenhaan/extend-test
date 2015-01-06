(ns extend-test.core.shim)

(def handler-var 'extend-test.core.handler/app)

(defn- require-and-resolve [sym]
  (require (symbol (namespace sym)))
  (resolve sym))

(def handler-store (atom nil))

(defn initialize!  []
  (reset! handler-store
    (require-and-resolve handler-var)))

(defn handler [r]
  (@handler-store r))
