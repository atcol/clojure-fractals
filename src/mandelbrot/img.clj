(ns mandelbrot.img
  (:use [mandelbrot.core])
  (import java.io.File)
  (import java.awt.Color)
  (import java.awt.image.BufferedImage)
  (import javax.imageio.ImageIO)
  (:gen-class))

(def WIDTH 800)
(def HEIGHT 600)

(defn draw
  [g x y]
  (let [xCoord (+ 200 x) yCoord (+ 100 y)]
    ;(println "Drawing " xCoord "," yCoord)
    (.drawOval g xCoord yCoord 450 450)))

(defn -main
  [fileName]
  (let [bi (BufferedImage. WIDTH HEIGHT BufferedImage/TYPE_INT_ARGB) 
        g (.getGraphics bi)]
    (doseq [y (range 1 -1 -0.05)]
      (doseq [x (range -2 0.5 0.0315)]
        (if (in? [x y] 200) (draw g x y))))
    (ImageIO/write bi "png"  (File. fileName))))

