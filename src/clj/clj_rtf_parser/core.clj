(ns clj-rtf-parser.core
  (:require [clojure.java.io :as io]
            [clojure.string :as cstr])
  (:import [com.rtfparserkit.parser RtfStreamSource]
           [com.rtfparserkit.parser.standard StandardRtfParser]
           [com.rtfparserkit.converter.text StringTextConverter]))

;; -----------------------------------------------------------------------------
;; Protocol
;; -----------------------------------------------------------------------------

(defprotocol IRtfParser
  (get-rtf-text [rtf-input]))

;; -----------------------------------------------------------------------------
;; Implementations for the protocol. Adding as needed...
;; -----------------------------------------------------------------------------

(extend-protocol IRtfParser
  java.lang.String
  (get-rtf-text [rtf-string]
    (let [inp-stream (io/input-stream (.getBytes rtf-string))
          converter (StringTextConverter.)
          rtf-stream (RtfStreamSource. inp-stream)]
      (.convert converter rtf-stream)
      (.getText converter))))

;; -----------------------------------------------------------------------------
;; Preprocessing functions to take care of some issues with the input
;; -----------------------------------------------------------------------------

(defn split-par-from-words
  "In lots of input, the par tag is immediately followed by actual words
   without a space or different delimiter in-between. This function adds
   it back."
  [rtf-string]
  (cstr/replace rtf-string #"(\\par(?!(arsid[0-9]+)|d\\))" "$1 "))
