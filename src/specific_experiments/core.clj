(ns specific-experiments.core
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen])
  (:gen-class))

(s/conform even? 1000) ;; conform returns the (destructured) value or :clojure.spec.alpha/invalid
(s/valid? even? 100)

(import java.util.Date)
(s/valid? inst? (Date.))

(s/valid? #{:club :diamond} :club)


(s/def ::est-id (s/and number? int? pos?))
(s/def ::country-iso (s/and string? some?))
(s/def ::est-schema
  (s/keys
   :req [::est-id
         ::country-iso]))

(s/valid?
 ::est-schema
 {::country-iso "UK"
  ::est-id 222})

(gen/sample (s/gen ::est-schema) 5)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
