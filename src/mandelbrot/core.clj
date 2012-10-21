(ns mandelbrot.core
  (:gen-class))

(def MAX_ITER 50)

(defn mag [a b] 
  "Returns sqrt(a² + b²)"
  (Math/sqrt (+ (* a a) (* b b))))

(defn iter-z [z Cx Cy]
  (+ (* z z) (mag Cx Cy)))

(defn in? [[Cx Cy] I]
  "Return true if [Cx,Cy] is in the mandelbrot set by iterating from Z0 until the magnitude of Z >= 2, or we exceed I. Recall that z = z² + c"
  (loop [z 0 i 0]
    (if (< z 2) (if (< i I) (recur (iter-z z Cx Cy) (inc i)) true) false)))

(defn build [C N]
  "Yields a mandelbrot set bounded by C and N"
  (if (< C N)
    (filter #(in? %1 MAX_ITER) (map #(vec [%1 %1]) (range C N 0.1)))
    []))
