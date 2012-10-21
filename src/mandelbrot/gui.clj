(ns mandelbrot.gui
  (:use [mandelbrot.core])
  (:import (java.awt BorderLayout Dimension Graphics Color))
  (:import (javax.swing JFrame JPanel)))

;(def frame (JFrame. "Mandelbrot in Clojure"))

;(def canvas 
  ;(proxy [javax.swing.JPanel] []
    ;(paintComponent [#^java.awt.Graphics g]
        ;(let [points (build 10.0 20.0)]
          ;(map #(do (println %1) (.drawRect (%1 0) (%1 1) 1 1)) points)))))
 
;(doto canvas
    ;(.setPreferredSize (Dimension. 800 700)))

;(doto frame
    ;(.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
    ;(.setContentPane canvas)
    ;(.pack) 
    ;(.setVisible true))

(defn -main
  []
  (let [frame (JFrame. "Mandelbrot in Clojure")
        canvas (proxy [javax.swing.JPanel] []
                (paintComponent [#^java.awt.Graphics g]
                  (let [points (build 10.0 20.0)]
                    (map #(do (println "Point is " %1) (.drawRect (%1 0) (%1 1) 1 1)) points))))
       ]
    (doto frame
        (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
        (.setContentPane canvas)
        (.pack) 
        (.setVisible true))))
