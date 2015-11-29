(require
 '[figwheel-sidecar.repl-api :as ra])

(defn start []
  (ra/start-figwheel!
   {:figwheel-options {} ;; <-- figwheel server config goes here 
    :build-ids ["dev"]   ;; <-- a vector of build ids to start autobuilding
    :all-builds          ;; <-- supply your build configs here
    [{:id "dev"
      :figwheel true
      :source-paths ["src"]
      :compiler {:main "example.core"
                 :asset-path "out"
                 :output-to "resources/public/main.js"
                 :output-dir "resources/public/out"
                 :verbose true}}]}))

;; Please note that when you stop the Figwheel Server http-kit throws
;; a java.util.concurrent.RejectedExecutionException, this is expected

(defn stop []
  (ra/stop-figwheel!))

(defn repl []
  (ra/cljs-repl))
