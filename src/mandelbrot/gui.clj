(ns mandelbrot.gui
  (:use [mandelbrot.core])
  (:import (java.awt Dimension Graphics Color))
  (:import (javax.swing JFrame JPanel)))

(def WINDOW_SIZE (Dimension. 1024 768))

(def WIDTH 800.0)
(def HEIGHT 800.0)
(def scale 0.002)

(defn -main
  []
  (let [frame (JFrame. "Mandelbrot in Clojure")
        canvas (proxy [javax.swing.JPanel] []
                (paintComponent [#^java.awt.Graphics g]
                  (def x1 -800.0)
                  (def y1 -800.0)
                  (def x2 WIDTH)
                  (def y2 HEIGHT)
                  (dotimes [i WIDTH]
                    (dotimes [j HEIGHT]
                      (def xN (* (+ x1 i) scale))
                      (def yN (* (+ y1 j) scale))
                      ; (println "xN,yN are [" xN "," yN "] with i,j = " i "," j)
                      (if (in? [xN yN] MAX_ITER)
                        (do 
                          (println xN "," yN)
                          (.drawRect g (+ (/ WIDTH 2) (/ xN scale)) (+ (/ HEIGHT 2) (/ yN scale)) 1 1)))))))]

    (doto canvas
        (.setPreferredSize WINDOW_SIZE)
        (.setAlignmentX java.awt.Component/CENTER_ALIGNMENT))
    (doto frame
        (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
        (.setPreferredSize WINDOW_SIZE)
        (.setContentPane canvas)
        (.pack) 
        (.setVisible true))))
