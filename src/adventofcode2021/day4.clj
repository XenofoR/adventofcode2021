(ns adventofcode2021.day4
  (:require [adventofcode2021.inputUtils :as utils]))

(def fileInput (line-seq (clojure.java.io/reader "../../resources/day4.input")))

(def drawnNumbers (reduce conj () (.split (nth (filter #(.contains % ",") fileInput) 0) ",")))
(def boards (vec (remove #(.isEmpty % ) (filter #(.contains % " ") fileInput))))
(defn checkIfWon [board]
  (def rowResult (for [b board]
     (count (filter #(= % "X") b))))

    (def firstColumn (reduce conj [] (map #(nth % 0) board)))
    (def secondColumn (reduce conj [] (map #(nth % 1) board)))
    (def thirdColumn (reduce conj [] (map #(nth % 2) board)))
    (def forthColumn (reduce conj [] (map #(nth % 3) board)))
    (def fifthColumn (reduce conj [] (map #(nth % 4) board)))
  (def allColumns [firstColumn secondColumn thirdColumn forthColumn fifthColumn])

  (def columnResult (for [a allColumns]
    (count (filter #(= % "X") a))))

  (if (.contains (reduce conj rowResult columnResult) 5)
    true
    false)
  )

(defn markNumber [boardNumber drawnNumber]
  (if (= boardNumber drawnNumber)
    "X"
    boardNumber)
  )

(defn markRow [row drawnNumber]
  (vec (map #(markNumber % drawnNumber) row))
  )

(defn calculateScore [board drawnNumber]
  (def mergeBoard (remove #(= % "X") (reduce concat board)))
  (def score (* (reduce + (map #(Integer/parseInt %) (remove #(= % "") mergeBoard)) ) (Integer/parseInt drawnNumber)))
  score
  )

(defn playGame [board numbers drawIndex]
  (def newBoard (for [b board] (markRow b (first numbers))))
  (try (if (checkIfWon newBoard )
     (list (calculateScore newBoard (first numbers)) drawIndex)
     (playGame newBoard (rest numbers) (inc drawIndex))
    )
       (catch Exception e (println (.printStackTrace e))))
  )

(def gameBoards (for [i (range 0 99)]
  (vec (map vec (map #(.split % " ") (subvec boards (+ 0 (* i 5)) (+ 5 (* i 5))))))
  ))


(println (for [b gameBoards]
           (playGame b (reverse drawnNumbers) 1)))




