(ns adventofcode2021.day1
  (:require [adventofcode2021.inputUtils :as utils]))

(def input (map #(Integer/parseInt %) (utils/getListFromFile "../../resources/day1.input")))

(defn checkNextInc [prev list result]
  (if (empty? list)
    result
    (if (> prev (first list))
      (checkNextInc (first list) (rest list) (inc result))
      (checkNextInc (first list) (rest list) result)))
  )

(print (checkNextInc 0 input 0))