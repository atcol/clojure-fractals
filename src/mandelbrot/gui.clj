(ns mandelbrot.gui
  (:use [mandelbrot.core])
  (:import (java.awt Dimension BorderLayout))
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
                  (dotimes [i WIDTH]
                    (dotimes [j HEIGHT]
                      (def xN (* i scale))
                      (def yN (* j scale))
                      (if (in? [xN yN] MAX_ITER)
                        (do 
                          ;(println xN "," yN)
                          (.drawRect g i j 1 1)))))))]

    (doto panel
      (.setPreferredSize WINDOW_SIZE))
    (doto frame
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setPreferredSize WINDOW_SIZE)
      (.setLayout (BorderLayout.))
      (.add panel BorderLayout/CENTER)
      (.pack) 
      (.setVisible true))))
