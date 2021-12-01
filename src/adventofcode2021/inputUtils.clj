(ns adventofcode2021.inputUtils)

(defn getListFromFile [fileName]
  (with-open [reader (clojure.java.io/reader fileName)]

    (reduce conj () (line-seq reader) )))

(defn getMapFromFile [fileName]
  (
    with-open [reader (clojure.java.io/reader fileName)]
    (def split_vector (doall (map #(clojure.string/split %1 #":") (line-seq reader))))
    (println split_vector)
    (apply hash-map (reduce concat split_vector))
    )
  )