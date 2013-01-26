(ns tomafro.random)

(def secure-random (java.security.SecureRandom/getInstance "SHA1PRNG"))

(def base36-chars (vec (map char (concat (range 48 58) (range 97 123)))))

(def base62-chars (vec (map char (concat (range 48 58) (range 65 91) (range 97 123)))))

(defn random-int-seq [n]
  (repeatedly #(.nextInt secure-random n)))

(defn random-element-seq [elements]
  (map #(get elements %) (random-int-seq (count elements))))

(defn random-string [length elements]
  (apply str (take length (random-element-seq elements))))

(defn base36 [length]
  (random-string length base36-chars))

(defn base62 [length]
  (random-string length base62-chars))
