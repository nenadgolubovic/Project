(ns api_controller.get_flight_data
  (:require [clj-http.client :as client])
  ;(:require [api-controller.api-config1 :as api-config])
  (:require [clojure.edn :as edn])
  )


(defn connect-api-schipol-airport
  []
  (let [response (client/get (:api-url (edn/read-string (slurp "resources/config.edn"))) {:headers (:api-params (edn/read-string (slurp "resources/config.edn")))})]
    response))


