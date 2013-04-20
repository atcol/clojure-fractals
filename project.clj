(defproject mandelbrot "1.0.0-SNAPSHOT"
  :description "A renderer of the Mandelbrot set"
  :dependencies [[org.clojure/clojure "1.4.0"]]
  :aot [mandelbrot.img]
  :main mandelbrot.img)
