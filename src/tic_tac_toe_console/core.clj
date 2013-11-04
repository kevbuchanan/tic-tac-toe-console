(ns tic-tac-toe-console.core
  (:require
    [tic-tac-toe.board :refer [new-board]]
    [tic-tac-toe-console.round :refer [start]]
    [clojure.tools.cli :refer [cli]]))

(defn -main [& args]
  (let [[options args banner] (cli args
    ["-h" "--help" "Show help" :flag true :default false]
    ["-o" "--order" "1 to go first, 2 to go second" :default 1 :parse-fn #(Integer. %)]
    ["-s" "--size" "3 to 7, for 3x3 to 7x7 board" :default 3 :parse-fn #(Integer. %)]
    ["-d" "--difficulty" "1: easy, 2: medium, 3: hard" :default 2 :parse-fn #(Integer. %)])]
    (if (or (:help options)
        (not (contains? #{1 2 3} (:difficulty options)))
        (not (contains? #{3 4 5 6 7} (:size options))))
      (println banner)
      (if (= 1 (:order options))
        (start {:players [:human :ai] :pieces [:X :O] :board (new-board (:size options)) :difficulty (:difficulty options)})
        (start {:players [:ai :human] :pieces [:O :X] :board (new-board (:size options)) :difficulty (:difficulty options)})))))

