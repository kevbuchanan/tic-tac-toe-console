(defproject tic-tac-toe-console "0.1.1"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.4"]
                 [tic-tac-toe "0.1.0-SNAPSHOT"]]
  :main tic-tac-toe-console.core
  :profiles {:dev {:dependencies [[speclj "2.5.0"]]}}
  :plugins [[speclj "2.5.0"]]
  :test-paths ["spec/"])
