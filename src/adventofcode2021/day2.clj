(ns adventofcode2021.day2
  (:require [adventofcode2021.inputUtils :as utils]))
(def input (utils/getListFromFile "../../resources/day2.input"))

(defn convertToIntAndAdd "Maps a List of Vectors to integers and reduces with +" [values]
  (reduce + (map #(Integer/parseInt %) (map second values))))

(defn filterCommands "Filter a list of Vectors based on string type" [commandToFilter commands]
  (filter #(= commandToFilter (first %)) commands)
  )

(def commands (map #(.split % " ") input))

(def horizontal  (convertToIntAndAdd (filterCommands "forward" commands)))
(def depth (- (convertToIntAndAdd (filterCommands "down" commands)) (convertToIntAndAdd (filterCommands "up" commands))))
(println "horizontal " horizontal)
(println "depth " depth)
(println "total " (* horizontal depth))