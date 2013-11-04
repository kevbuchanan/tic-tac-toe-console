(ns tic-tac-toe-console.interface
  (:require [tic-tac-toe.board :refer [empty-space board-size]]
            [tic-tac-toe.validations :refer [valid-move?]]))

(defn print-board [board]
  (println "\n\n\n\n\n\n")
  (let [rows (partition (board-size board) (map-indexed #(if (= empty-space %2) (format "%2s" (inc %1)) (format "%2s" (name %2))) board))]
    (loop [print-lines (map #(interpose " |" %) rows)]
      (apply println (first print-lines))
      (if (empty? (rest print-lines))
        nil
        (recur (rest print-lines))))))

(defn declare-winner [piece board]
  (print-board board)
  (println (str (name piece) " won"))
  :win)

(defn declare-draw [board]
  (print-board board)
  (println "Draw")
  :draw)

(defn show-turn [piece board]
  (print-board board)
  (println (str (name piece) ", your move")))

(defn request-human-move [board piece]
  (println "Enter a space number")
  (let [input (read-line)
        move (try (read-string input) (catch Exception e))]
    (if (valid-move? move board)
      (- move 1)
      (recur board piece))))
