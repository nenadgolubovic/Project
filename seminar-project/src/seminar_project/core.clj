(ns seminar-project.core
  (:require [ApiController.get-flight-data :as api-request]))

(api-request/connect-api-schipol-airport)


;1. The user enters his reservation in the program so that the program gives him all the information about the flight for which he left the reservation

(def reservation-number  "112")



(def flights
  [{:reservation-number "111" :flight-number "AA123" :departure "2024-11-25" :origin "Belgrade" :destination "Los Angeles" :status "On Time"}
   {:reservation-number "112" :flight-number "AA123" :departure "2024-11-25" :origin "Belgrade" :destination "Los Angeles" :status "On Time"}
   {:reservation-number "113" :flight-number "AA123" :departure "2024-11-25" :origin "Belgrade" :destination "Los Angeles" :status "On Time"}
   {:reservation-number "123" :flight-number "BB456" :departure "2024-11-26" :origin "Frankfurt" :destination "Belgrade" :status "Delayed"}
   {:reservation-number "124" :flight-number "CC789" :departure "2024-11-27" :origin "London" :destination "Las Vegas" :status "Cancelled"}])

;Function which looking for flights based on reservation-number
(defn find-flight [reservation-number]
  (some #(if (= (:reservation-number %) reservation-number) %) flights))

;Function which display info of flight
  (defn display-flight-info [reservation-number]
    (let [flight (find-flight reservation-number)]
      (if flight
        (println (str "Flight Number: " (:flight-number flight) "\n"
                      "Departure Date: " (:departure flight) "\n"
                      "Origin: " (:origin flight) "\n"
                      "Destination: " (:destination flight) "\n"
                      "Status: " (:status flight)))
        (println "Flight not found."))))

;2. The user enters the destination and flight time so that the program will recommend the flight time to avoid the biggest delay and potentially be late to the arrival destination

