(defproject clj-rtf-parser "0.1.1"
  :description "Tiny clojure wrapper and copy of the code from https://github.com/joniles/rtfparserkit"
  :url "https://github.com/lambda-ai/clj-rtf-parser"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.sun.xml.txw2/txw2 "20110809"]
                 [junit/junit "4.12"]]
  :plugins [[lein-junit "1.1.8"]]

  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :java-source-paths ["src/java" "test/java"]
  :junit ["test/java"])
