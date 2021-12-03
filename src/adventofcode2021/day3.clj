(ns adventofcode2021.day3
  (:require [adventofcode2021.inputUtils :as utils]))


(def input (map utils/stringToCharVector (utils/getListFromFile "../../resources/day3.input")))

(defn filterBits [bitVector]
  (def numOne (count (filter #(= \1 %) bitVector)))
  (def numZero (count (filter #(= \0 %) bitVector)))
  (if (= (max numOne numZero) numOne)
    (list 1 0)
    (list 0 1))
  )

(defn addTuples [tuple1 tuple2]
  (list (str (nth tuple1 0) (nth tuple2 0)) (str (nth tuple1 1) (nth tuple2 1)))
  )

(def consumption (map #(Integer/parseInt % 2) (reduce addTuples (for [i (range 12)]
                                                                  (filterBits (map #(nth % i) input))
                                                                  ))))

(println (* (nth consumption 0) (nth consumption 1)))