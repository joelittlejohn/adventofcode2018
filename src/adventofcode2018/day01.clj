(ns adventofcode2018.day01
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

;; --- Day 1: Chronal Calibration ---

(def frequency-changes
  (map #(Integer/valueOf %) (-> (slurp (io/resource "day01/input"))
                                (str/replace "+" "")
                                str/split-lines)))

(reduce #(+ %1 %2) 0 frequency-changes) ; => 508

;; --- Part Two ---

(->> (reductions #(+ %1 %2) 0 (cycle frequency-changes))
     (reduce #(if (%1 %2) (reduced %2) (conj %1 %2)) #{})) ;; => 549
