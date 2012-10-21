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

(defn build [[x1 y1] [x2 y2]]
  "Yield a Mandelbrot set from x1, y1 to x2, y2"
  (let [pnts []] ; I 1 J 1 xN (+ x1 1) yN (+ y1 1)]
;    (dotimes [i (- x2 x1)]
;      (dotimes [j (- y2 y1)]
;        (def xN (+ x1 i))
;        (def yN (+ y1 j))
;        ;(println "xN,yN are [" xN "," yN "] with i,j = " i "," j)
;        (if (in? [xN yN] MAX_ITER)
;          (conj pnts [xN yN]))))
    pnts))

;(defn build [C N]
  ;"Yields a mandelbrot set bounded by C and N"
  ;(if (< C N)
    ;(filter #(in? %1 MAX_ITER) (map #(vec [%1 %1]) (range C N 1))))
    ;[])
;
        ;(if (and (< xN x2) (< yN y2))
