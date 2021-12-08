(ns adventofcode2021.day7)

(def input (map #(Integer/parseInt %) (.split (nth (line-seq (clojure.java.io/reader "../../resources/day7.input")) 0) ",")))

(defn calculateAlignmentCost [position alignment]
  (- (max position alignment) (min position alignment))
  )

(defn calculateAlignmentCostIncremental [position alignment]
  (def diff (- (max position alignment) (min position alignment)))
  (reduce + (range (inc diff)))
  )

(println (reduce min (for [i input]
                (reduce + (map #(calculateAlignmentCost % i) input))
                )))

(println (reduce min (for [i input]
                       (reduce + (map #(calculateAlignmentCostIncremental % i) input))
                       )))

