(ns adventofcode2021.day6)

(def input (map #(Integer/parseInt %) (.split (nth (line-seq (clojure.java.io/reader "../../resources/day6.input")) 0) ",")))

(defn growth [timer]
  (if (= timer 0)
    (list 6 8)
    (dec timer)
    )
  )

(defn breed [input totalCycles currentCycle]
  (if (= totalCycles currentCycle)
    (count (flatten (pmap growth input)))
    (breed (flatten (pmap growth input)), totalCycles, (inc currentCycle))
    )
  )


(println (breed input, 80, 1))