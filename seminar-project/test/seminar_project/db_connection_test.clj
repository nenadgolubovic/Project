(ns seminar-project.db-connection-test
  (:require [clojure.test :refer :all]))


(fact "Test of db connection"
      (let [pera (atom {:balance 100})
            mika (atom {:balance 50})]
        (transfer mika pera 55) =not=> nil
        (transfer mika pera 500) => (throws Exception)))