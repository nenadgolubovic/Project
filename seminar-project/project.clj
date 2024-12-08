(defproject seminar-project "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"] [clj-http "3.12.3"]
                 ;Source : https://santhoshkris.medium.com/postgres-with-clojure-and-honeysql-cb666a28d803
                 [com.github.seancorfield/next.jdbc "1.3.834"]
                 [org.postgresql/postgresql "42.2.10"]
                 [com.github.seancorfield/honeysql "2.3.928"]
                 ]
  :repl-options {:init-ns seminar-project.core})
