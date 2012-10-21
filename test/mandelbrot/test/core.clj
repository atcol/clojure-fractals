(ns mandelbrot.test.core
  (:use [mandelbrot.core])
  (:use [clojure.test]))

(def ITERS 50)

(deftest test-iter-z
  (is (= 0.0 (iter-z 0 -2 2)))
  (is (= 2.0 (iter-z 0 1 1))))

(deftest test-in-false 
  (is (not (in? [-2, 2] ITERS))); diverges on first iter as Z² + sqrt(-2² + 2²) = 0 + 2.8... > 2
  (is (not (in? [1.0, 1.0] ITERS)))
  (is (not (in? [2.0, 2.0] ITERS)))
  (is (not (in? [3.0, 3.0] ITERS)))
  (is (not (in? [4.0, 4.0] ITERS)))
  (is (not (in? [5.0, 5.0] ITERS))))

(deftest test-in-true 
  (is (in? [0, 0] ITERS))
  (is (in? [0.16, 0.12] ITERS)
  (is (in? [0.24, 0.08] ITERS))

(deftest test-abs
  (is (= 2.23606797749979 (abs 1 2)) "sqrt(1² + 2²) = 2.236..."))

(deftest test-build-invalid-input
  (is (empty? (build [0 0] [0 0])))
  (is (empty? (build [1 0] [0 0]))))

(deftest test-build-valid-input
  (not (empty? (build [0.0 0.0] [10.0 10.0]))))
