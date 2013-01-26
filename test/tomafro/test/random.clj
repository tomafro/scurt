(ns tomafro.test.random
  (:use [midje.sweet]
        [tomafro.random]))

(facts "base36"
  (fact "takes a given number of characters from a random sequence of base62 characters"
    (base36 4) => "a1b2"
    (provided (random-element-seq base36-chars) => [\a \1 \b \2 \c \3 \d \4])))

(facts "base62"
  (fact "takes a given number of characters from a random sequence of base62 characters"
    (base62 4) => "a1b2"
    (provided (random-element-seq base62-chars) => [\a \1 \b \2 \c \3 \d \4])))