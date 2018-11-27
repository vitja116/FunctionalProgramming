(ns Lab6)

; Uzdevums 1

(defn max-number [& numbers]
  (reduce (fn [maximal current] (if (> current maximal) current maximal)) numbers))

(println "Testing max-number:\t"
         (and (= (max-number 1 8 3 4) 8)
              (= (max-number 30 20) 30)
              (= (max-number 45 67 11) 67)))

; max-number can also be defined as an anonymous function
;(println "Anonymous max-number: "
;         ((fn [& numbers]
;            (reduce (fn [maximal current] (if (> current maximal) current maximal)) numbers))
;           1 8 3 4))

; Uzdevums 2
(defn palindrome [word]
  (or (< (count word) 2)
    (and (= (first word) (last word))
         (palindrome (rest (butlast word))))))

(println "Testing palindrome:\t"
       (and (false? (palindrome '(1 2 3 4 5)))
            (true? (palindrome "racecar"))
            (true? (palindrome [:foo :bar :foo]))
            (true? (palindrome '(1 1 3 3 1 1)))
            (false? (palindrome '(:a :b :c)))))

; Palindrome also can be defined as an anonymous function
;(print ((fn [word]
;           (or (< (count word) 2)
;               (and (= (first word) (last word))
;                    (palindrome (rest (butlast word)))))) "racecar"))
