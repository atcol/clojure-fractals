(ns mandelbrot.gui
  (:use [mandelbrot.core])
  (:import (java.awt Dimension))
  (:import (javax.swing JFrame JPanel)))

(def WINDOW_SIZE (Dimension. 1024 768))

(def WIDTH 800.0)
(def HEIGHT 800.0)
(def scale 0.002)

(defn -main
  []
  (let [frame (JFrame. "Mandelbrot in Clojure")
        panel (proxy [javax.swing.JPanel] []
                (paintComponent [#^java.awt.Graphics g]
                  (def x1 -800.0)
                  (def y1 -800.0)
                  (def x2 WIDTH)
                  (def y2 HEIGHT)
                  (dotimes [i WIDTH]
                    (dotimes [j HEIGHT]
                      (def xN (* (+ x1 i) scale))
                      (def yN (* (+ y1 j) scale))
                      (if (in? [xN yN] MAX_ITER)
                        (do 
                          ;(println xN "," yN)
                          (.drawRect g (+ (/ WIDTH 2) (/ xN scale)) (+ (/ HEIGHT 2) (/ yN scale)) 1 1)))))))]

    (doto panel
      (.setPreferredSize WINDOW_SIZE))
    (doto frame
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.add panel)
      (.pack) 
      (.setVisible true))))
