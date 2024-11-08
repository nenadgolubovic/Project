(ns ApiController.api-requests
  (:require [clj-http.client :as client])
  (:require [ApiController.api-config :as api-config])
  )

(defn connect-api-schipol
  []
  (let [response (client/get api-config/http-call {:headers api-config/params})]
    response))