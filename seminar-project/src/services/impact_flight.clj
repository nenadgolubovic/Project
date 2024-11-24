`(ns services.impact-flight)
(import '[java.time LocalTime])

(def flights
  {:flight1 {:initial-arrival-time 1 :delay 2 :turnaround-time 3}
   :flight2 {:initial-arrival-time 2 :delay 0 :turnaround-time 3}
   :flight3 {:initial-arrival-time 5 :delay 1 :turnaround-time 3}
   :flight4 {:initial-arrival-time 7 :delay 2 :turnaround-time 3}})


(defn add-actual-arrival-time
  "add actual arrival time to map, To determinate actual arrival time from one gate it need to calculate initial arrival time + delay"
  [m]
  (map (fn [[k v]] [k (assoc v :actual-arrival-time (apply + (map v [:initial-arrival-time :delay])))]) m))

(defn min-departure-time [arrival-time delay-a turnaround-time] (reduce + [arrival-time delay-a turnaround-time]))

(defn add-min-dep-time
  "add actual arrival time to map, To determinate min departure time from one gate it need to calculate initial arrival time + delay + turnaroundtime"
  [m]
  (map (fn [[k v]] [k (assoc v :min-dep-time (apply min-departure-time (map v [:initial-arrival-time :delay :turnaround-time])))]) m))


;define gates, take available-on which present time when this will be available, open-on, time when gate is open, closed-on present time when it is closed
(def gates {:gate1 {:available-on 6 :open-on 1 :closed-on 10}
            :gate2 {:available-on 5 :open-on 1 :closed-on 10}
            :gate3 {:available-on 5 :open-on 1 :closed-on 10}
            })


(defn def-new-available-on-time
  [start turn-around-time m gate]
  (if (< (:available-on (get m gate)) start)
    (assoc-in m [gate :available-on] (+ start turn-around-time))))


(def-new-available-on-time 2 5 gates :gate1)

(defn find-gate [max-available m]
  (some #(when (<= (:available-on (val %)) max-available) (key %)) m))

(defn find-gate
  "Function will find gate which are available on actual arrival time, If not find, take gate which has less available on time (first which will be free)"
  [max-available m]
  (let [gate (some #(when (<= (:available-on (val %)) max-available) (key %)) m)]
    (if gate
      gate
      (key (apply min-key #(get (val %) :available-on) m)))))


(find-gate 3 gates)




(defn assign-gate-to-flight
  [gates flight]
  (let [max-available (get-in flight [:initial-arrival-time])]
    (assoc flight :gate (find-gate max-available gates))))


(def a  {:initial-arrival-time 1 :delay 2 :turnaround-time 3})

(assign-gate-to-flight gates a)

(defn find-gate-for-all-flights
  [gates flights]
  (into {} (map (fn [[k v]]
                  [k (assign-gate-to-flight gates v)]) ; samo prosleđuješ vrednost
                flights)))

(find-gate-for-all-flights gates flights)

