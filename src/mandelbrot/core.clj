(ns mandelbrot.core
  (:gen-class))

(def MAX_ITER 25)

(defn abs [a b] 
  "Returns sqrt(a² + b²)"
  (Math/sqrt (+ (* a a) (* b b))))

(defn iter-z [z Cx Cy]
  (+ (* z z) (abs Cx Cy)))

(defn in? [[Cx Cy] I]
  "Return true if [Cx,Cy] is in the mandelbrot set by iterating from Z0 until the abs of Zn >= 2, or we exceed I iterations. Recall that Zn = Zn-1² + c"
  (loop [z 0 i 1]
    ;(println "z is " z "Cx and Cy are [" Cx ", " Cy "] and i is " i " z > 2.0" (> z 2.0) " and i < I " (< i I))
    (if (> z 2.0) false (if (< i I) (recur (iter-z z Cx Cy) (inc i)) true))))
