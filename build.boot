(set-env!
  :resource-paths #{"resources"}
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.9.0-alpha12"]
                  [org.clojure/clojurescript "1.9.293"]
                  [adzerk/boot-cljs "1.7.228-2"]
                  [adzerk/boot-reload "0.4.13" :scope "test"]
                  [tailrecursion/boot-jetty "0.1.3"]
                  [cljsjs/maptastic "0.0.0"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[boot.task.built-in :refer :all]
         '[adzerk.boot-reload :refer [reload]]
         '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev []
  (comp
   (watch)
   (reload)
   (cljs)
   (serve :port 8000)))
