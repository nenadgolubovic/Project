(ns seminar-project.core
  (:require [clj-http.client :as client]))

(def http-call "https://api.schiphol.nl/public-flights/flights?includedelays=false&page=0&sort=%2BscheduleTime")

(def params {:Accept "application/json"
             :app_id "82405ed0"
             :app_key "9d7ffea2adf25591b3b527d5a61b761d"
             :ResourceVersion "v4"})

(defn api-schiphol
  []
  (let [response (client/get http-call {:headers params})]
    response))

(def a 6)