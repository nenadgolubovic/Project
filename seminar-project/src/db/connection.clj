(ns db.connection
  (:require [next.jdbc :as jdbc]))
(def db-config
  {:dbtype "postgresql"
   :dbname "schipol_flights_db"
   :host "localhost"
   :user "postgres"
   :port 5432
   :password "nenad123"})
(def db (jdbc/get-datasource db-config))

;I am trying to connect database, I will make test table to test connection
(def create-table-query
  "CREATE TABLE test_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    flight_number VARCHAR(20),
    departure_time TIMESTAMP
  )")
(jdbc/execute! db [create-table-query])
(jdbc/execute! db ["SELECT * FROM test_table"])
(jdbc/execute! db ["
 insert into test_table (id, name, flight_number, departure_time)
  values(1,'flight1','123', '2024-12-08 15:39:00')"])
(jdbc/execute! db ["SELECT * FROM test_table"])

