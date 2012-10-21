(ns mandelbrot.test.core
  (:use [mandelbrot.core])
  (:use [clojure.test]))

(def ITERS 50)

(deftest test-iter-z
  (is (= 2.0 (iter-z 0 1 1))))

(deftest test-in-false 
  (is (= false (in? [0, 0] ITERS))))

(deftest test-in-true 
  (is (in? [-1, -1] ITERS))
  (is (in? [-1.1, -1.1] ITERS))
  (is (in? [-1.3, 1.3] ITERS))
  (is (in? [-1.38, -1.38] ITERS)))
         ; c = 0, -1, -1.1, -1.3, -1.38

(deftest test-mag
  (is (= 2.23606797749979 (mag 1 2)) "sqrt(1² + 2²) = 2.236..."))

(deftest test-build
  (is (= (empty? (build 0 0))) "0 0 yields empty set")
  (is (= (empty? (build 1 0))) "c > N yields empty set")
  (is (not (empty? (build 1 100))) "non-empty set"))

(println (build -10.0 -1.0))
(println (build 10.0 20.0))
  
