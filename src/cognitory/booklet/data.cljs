(ns cognitory.booklet.data)

(def chapters
  [
   {:title "Literals"
    :sections [ {:name "numbers"
                 :concepts [{:name "2 1.3"
                             :type :literal
                             :examples [{:in 2}
                                        {:in 1.3}
                                        {:in -2}
                                        {:in -1.3}]}]}

               {:name "strings"
                :concepts [{:name "\"abc\""
                            :type :literal
                            :explanation "Strings are used to represent text."
                            :uses ["To represent single characters, words, sentences, multi-line text, etc."]
                            :notes ["`\\n` is used to represent a new-line"]
                            :examples [{:in "\"a\""}
                                       {:in "\"Bob\""}
                                       {:in "\"hello world\""}]}]}

               {:name "booleans"
                :concepts [{:name "true false"
                            :type :literal
                            :examples [{:in 'true}
                                       {:in 'false}]}]}

               {:name "keywords"
                :concepts [{:name ":a"
                            :type :literal
                            :uses ["Inside of maps, as keys"
                                   "To represent commonly reused values in data, ex. `:male` and `:female`"]
                            :examples [{:in ':a}
                                       {:in ':hello}]}]}

               {:name "nil"
                :concepts [{:name "nil"
                            :type :literal
                            :examples [{:in nil}]}]}

               {:name "lists"
                :concepts [{:name "'( )"
                            :type :literal
                            :uses ["Rarely written in code directly, but, they are returned by many functions that work with vectors and sets."]
                            :examples [{:in "'(1 2 3 4)"}
                                       {:in "'(:a :b :c)"}]}]}

               {:name "vectors"
                :concepts [{:name "[ ]"
                            :type :literal
                            :uses ["To represent multiple values in a list"
                                   "Preferred to lists when writing code, because it is easier to write and distinguish `[]` than `'()`"]

                            :notes ["Most functions that work with lists also work with vectors"
                                    "Vectors allow you to access a value at a certain index directly (whereas lists do not)"]
                            :examples [{:in '[1 2 3 4]}
                                       {:in '[:a :b :c]}]}]}

               {:name "sets"
                :concepts [{:name "#{ }"
                            :type :literal
                            :explanation "Sets are sequences where each value is unique; a set will never contain the same value twice."
                            :uses ["To represent a group of values, where order does not matter, and where there should only be one of each value"]
                            :notes ["Most functions that work with lists also work with sets"]
                            :examples [{:in '#{1 2 3 4}}
                                       {:in '#{:a :b :c}}]}]}

               {:name "maps"
                :concepts [{:name "{ }"
                            :type :literal
                            :examples [{:in '{"a" 100
                                              "b" 200
                                              "c" 300}}
                                       {:in '{:name "Bob"
                                              :email "bob@example.com"}}]}]}

               {:name "functions"
                :concepts [{:name "(fn []  )"
                            :type :literal
                            :examples [{:in '(fn [x] (+ 1 x))}]}]}

               {:name "symbols"
                :concepts [{:name "'"
                            :type :literal
                            :explanation "Labels to other values. Clojure comes with labels for many functions (ex. `+`, `max`) but you can create your own labels for functions and values too."
                            :examples [{:in '+}
                                       {:in 'max}]}

                           {:name "def"
                            :type :literal
                            :explanation "Labels to other values. Clojure comes with labels for many functions (ex. `+`, `max`) but you can create your own labels for functions and values too."
                            :examples [{:in "(def x 10)
                                             (+ x 1)"
                                        :out 11}]}

                           {:name "let"
                            :type :literal
                            :explanation "Labels to other values. Clojure comes with labels for many functions (ex. `+`, `max`) but you can create your own labels for functions and values too."
                            :examples [{:in '(let [x 10]
                                               (+ x 5))
                                        :out 15}]}]}


               {:name "expressions"
                :concepts [{:name "(foo  )"
                            :type :literal
                            :examples [{:in '(foo "bar")}
                                       {:in '(+ 1 2 (* 4 5))}]}]}]}






   {:title "Numbers"
    :sections [ {:name "create"
                 :concepts [ {:name "1 1.5 -1 -1.5"
                              :type :literal
                              :examples [{:in 1}
                                         {:in 1.5}
                                         {:in -1}
                                         {:in -1.5}]}]}


                {:name "arithmetic"
                 :concepts [

                            {:name #'+
                             :type :function
                             :explanation "Add multiple numbers together."
                             :notes ["`(+)` returns `0`"]
                             :uses ["With `apply`, can sum a list"
                                    "With `apply`, can sum a list"]
                             :examples [{:in '(+ 1 1 1)
                                         :out 3}
                                        {:in '(apply + [1 1 1])
                                         :out 3}
                                        {:in '(reduce + [1 1 1])
                                         :out 3}]}

                            {:name #'-
                             :type :function
                             :explanation "Subract multiple numbers from x."
                             :notes ["`(- x)` is equivalent to `(- 0 x)`"]
                             :examples [{:in '(- 10 1 1)
                                         :out 8}
                                        {:in '(- 10)
                                         :out -10}]}

                            {:name #'/
                             :type :function
                             :explanation "Divide x by one or more ys."
                             :notes ["`(/ x)` is equivalent to `(/ 1 x)`"]
                             :examples [{:in '(/ 12 2)
                                         :out 4}
                                        {:in '(/ 12 2 3)
                                         :out 2}
                                        {:in '(/ 5)
                                         :out 0.2}]}

                            {:name #'*
                             :type :function
                             :explanation "Multiplies one or more numbers."
                             :notes ["`(*)` returns `1`"]
                             :examples [{:in '(* 2 2 2)
                                         :out 8}
                                        {:in '(* 2)
                                         :out 2}
                                        {:in '(*)
                                         :out 1}]}

                            {:name #'inc
                             :type :function
                             :explanation "Returns a number one greater than x."
                             :notes ["The same as `(+ x 1)`"]
                             :uses ["Most often inside of `map`, `update`, `update-in`, to increase a value by `1`."]
                             :examples [{:in '(inc 5)
                                         :out 6}
                                        {:in '(map inc [1 2 3 4])
                                         :out '(2 3 4 5)}
                                        {:in '(update [2 4 6] 0 inc)
                                         :out [3 4 6]}]}

                            {:name #'dec
                             :type :function
                             :explanation "Returns a number one less than x."
                             :notes ["The same as `(- x 1)`"]
                             :uses ["Most often inside of `map`, `update`, `update-in`, to decrease a value by `1`."]
                             :examples [{:in '(dec 5)
                                         :out 4}
                                        {:in '(map dec [1 2 3 4])
                                         :out '(0 1 2 3)}
                                        {:in '(update [2 4 6] 0 dec)
                                         :out [1 4 6]}]}

                            {:name #'max
                             :type :function
                             :explanation "Returns the greatest of the input numbers."
                             :uses ["To find the maximum of some numbers"
                                    "To clamp a number above some threshold"
                                    "To find the maximum of a list of numbers (with `apply`)"]
                             :examples [{:in '(max 5 1 2 6 2)
                                         :out 6}
                                        {:in '(let [x 10] 
                                                (max 0 x))
                                         :out 10}
                                        {:in '(let [x -5] 
                                                (max 0 x))
                                         :out 0}
                                        {:in '(apply max [5 1 2 6 2])
                                         :out 6}]}

                            {:name #'min
                             :type :function
                             :explanation "Returns the least of the input numbers."
                             :examples [{:in '(min 1 5 1 -1 0)
                                         :out -1}
                                        {:in '(apply min [1 5 1 -1 0])
                                         :out -1}]}]}



               {:name "test"
                :concepts [

                           {:name #'even?
                            :type :function
                            :examples [{:in '(even? 10)
                                        :out true}
                                       {:in '(even? 9)
                                        :out false}]}

                           {:name #'odd?
                            :type :function
                            :examples [{:in '(odd? 10)
                                        :out false}
                                       {:in '(odd? 9)
                                        :out true}]}]}



               {:name "compare"
                :concepts [

                           {:name #'==
                            :type :function
                            :explanation "Returns true if all numbers have the same value, otherwise returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out ["true" "false"]}
                            :examples [{:in '(== 1.5 (/ 3 2))
                                        :out true}
                                       {:in '(== 3 2 1)
                                        :out false}]}

                           {:name #'>
                            :type :function
                            :explanation "Returns true if each number is greater-than the next number, otherwise returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out ["true" "false"]}
                            :examples [{:in '(> 1 2)
                                        :out false}
                                       {:in '(> 2 2 1)
                                        :out false}
                                       {:in '(> 3 2 1)
                                        :out true}]}

                           {:name #'<
                            :type :function
                            :explanation "Returns true if each number is less-than the next number, otherwise returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out [true false]}
                            :examples [{:in '(< 2 1)
                                        :out false}
                                       {:in '(< 1 2 3)
                                        :out true}]}

                           {:name #'>=
                            :type :function
                            :explanation "Returns true if each number is greater-than-or-equal to the next number, otherwise returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out [true false]}
                            :uses ["In an `if` or `filter`, to check if one value is >= to another."
                                   "In an `if` or `filter`, to check if set of values is descending."]
                            :examples [{:in '(>= 1 2)
                                        :out false}
                                       {:in '(>= 1 1)
                                        :out true}
                                       {:in '(>= 3 2 2 1)
                                        :out true}
                                       {:in '(apply >= [3 2 2 1])
                                        :out true}]}

                           {:name #'<=
                            :type :function
                            :explanation "Returns true if each number is less-than-or-equal to the next number, otherwise returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out ["true" "false"]}
                            :uses ["In an `if` or `filter`, to check if one value is <= to another."                       
                                   "In an `if` or `filter`, to check if a value is between a certain range."]
                            :examples [{:in '(<= 2 1)
                                        :out false}
                                       {:in '(<= 1 1)
                                        :out true}
                                       {:in '(<= 1 2 2 3)
                                        :out true}
                                       {:in '(let [a 39]
                                               (<= 0 a 100))
                                        :out true}]}]}



               {:name "random"
                :concepts [

                           {:name #'rand
                            :type :function
                            :explanation "Returns a random decimal number between `0` (inclusive) and `1` (exclusive).\n\nIf `n` is provided, returns a random decimal number between `0` (inclusive) and `n` (exclusive)."
                            :examples [{:in '(rand)
                                        :out 0.002}
                                       {:in '(rand)
                                        :out 0.812}
                                       {:in '(rand 5)
                                        :out 1.4}
                                       {:in '(rand 5)
                                        :out 4.3}]}

                           {:name #'rand-int
                            :type :function
                            :explanation "Returns a random integer between `0` (inclusive) and `1` (exclusive)."
                            :examples [{:in '(rand-int 3)
                                        :out 2}
                                       {:in '(rand-int 3)
                                        :out 0}
                                       {:in '(rand-int 3)
                                        :out 1}]}]}]




    :exercises [{:in '(+ 1 (- 4 6) (/ 12 6))
                 :out 1}]}

   {:title "Booleans"
    :introduction "" ; TODO explain truthy / falsey
    :sections [

               {:name "create"
                :concepts [
                           {:name "true false"
                            :type :literal
                            :examples [{:in true}
                                       {:in false}]}

                           {:name #'boolean
                            :type :function
                            :explanation "Converts an input to `true` or `false`"
                            :notes ["Input values of `nil` or `false` will return `false`. Everything else returns `true`."]
                            :uses ["Usually unnecessary, because most functions handle truthy values as `true` and falsey values as `false`."
                                   "Sometimes necessary when some other part of the program is expecting exactly `true` or `false`."]
                            :diagram {:in ["a"]
                                      :out ["true" "false"]}
                            :examples [{:in '(boolean 3)
                                        :out true}
                                       {:in '(boolean [])
                                        :out true}
                                       {:in '(boolean nil)
                                        :out false}]}]}

               {:name "test"
                :concepts [

                           {:name #'=
                            :type :function
                            :explanation "Returns true if the values of all inputs are equal, otherwise, returns false."
                            :diagram {:in ["a" "b" "..."]
                                      :out ["true" "false"]}
                            :notes ["All input expressions will be evaluated."]
                            :uses ["In an `if` or `filter`, to check if two or more values are equal."
                                   "To check if all values in a list are equal (with `apply`)."]
                            :examples [{:in '(= 1 1)
                                        :out true}
                                       {:in '(= 1 0)
                                        :out false}
                                       {:in '(= (+ 1 1) 2 (- 3 1))
                                        :out true}
                                       {:in '(apply = [4 (/ 8 2) (* 2 2)])
                                        :out true}]}

                           {:name #'not=
                            :type :function
                            :explanation "The opposite of `=`. Returns false when all values are equal, otherwise true."
                            :notes ["Same as `(not (= x y ...))`"
                                    "All input expressions will be evaluated."]
                            :diagram {:in ["a" "b" "..."]
                                      :out ["true" "false"]}
                            :uses ["In an `if` or `filter`, to check if two values are not equal."]
                            :examples [{:in '(not= 1 1)
                                        :out false}
                                       {:in '(not= 1 0)
                                        :out true}]}]}

               {:name "combine"
                :concepts [

                           {:name "and"
                            :arglists [[] ['x] ['x '& 'next]]
                            :type :special-form
                            :explanation "Evaluates expressions one at a time, from left to right. If an expression returns falsey (`nil` or `false`), and returns that value and doesn't evaluate any of the other expressions, otherwise it returns the value of the last expression."
                            :diagram {:in ["a" "b" "..."]
                                      :out ["first falsey input" "last truthy input"]}
                            :uses ["In an `if` or `filter`, to check if all of a set of conditions are `true`"]
                            :notes ["`(and)` returns `true`."
                                    "`and` is a 'special form' not a function. Only the expressions until the first falsey value are evaluated (in a function, all input expressions are evaluated)"]
                            :examples [{:in '(and true true)
                                        :out true}
                                       {:in '(and true false)
                                        :out false}
                                       {:in '(and false true)
                                        :out false}]}

                           {:name "or"
                            :type :special-form
                            :arglists [[] ['x] ['x '& 'next]]
                            :diagram {:in ["a" "b" "..."]
                                      :out ["first truthy input" "last falsey input"]}
                            :notes ["`or` is a 'special form' not a function. Only the expressions until the first truthy value are evaluated (in a function, all input expressions are evaluated)"]
                            :uses ["In an `if` or `filter`, to check if any of a set of conditions are `true`"
                                   "To provide a default value in situations where some value may be `nil` or `false`"]
                            :examples [{:in '(or true false)
                                        :out true}
                                       {:in '(or nil false)
                                        :out false}
                                       {:in '(or nil 3)
                                        :out 3}]}

                           {:name #'not
                            :type :function
                            :explanation "Returns `true` if `x` is falsey, otherwise returns `false`."
                            :diagram {:in ["a"]
                                      :out ["true" "false"]}
                            :uses ["Inside of a multi-part conditional statement, to negate a logical value"]
                            :examples [{:in '(not true)
                                        :out false}
                                       {:in '(not false)
                                        :out true}
                                       {:in '(not 1)
                                        :out false}
                                       {:in '(not (contains? #{1 2 3} 1))
                                        :out false}]}]}

               {:name "branch"
                :concepts [

                           {:name "if"
                            :type :special-form
                            :arglists [['test-expr 'true-result-expr 'false-result-expr]]
                            :explanation "If test-expr is truthy, if will return true-result-expr, otherwise, it will return false-result-expr."
                            :notes ["`if` is a 'special form', not a function; only one of `true-result-expr` or `false-result-expr` is evaluated (with a function, all input expressions are evaluated before the function is applied)."]
                            :examples [{:in '(if true
                                               :a
                                               :b)
                                        :out :a}
                                       {:in '(if false
                                               5
                                               10)
                                        :out 10}
                                       {:in '(if "hello"
                                               true
                                               false)
                                        :out true}
                                       {:in '(if nil
                                               "a"
                                               "b")
                                        :out "\"b\""}
                                       {:in '(let [x 50]
                                               (if (= x 100)
                                                 "equal"
                                                 "different"))
                                        :out "\"different\""}
                                       {:in '(if true
                                               (+ 2 3)
                                               (+ 1 2))
                                        :out 5}]

                            :exercises [{:in '(if (+ 1 2)
                                                "a"
                                                "b")
                                         :out "\"a\""}
                                        {:in '(if [nil nil]
                                                "a"
                                                "b")
                                         :out "\"a\""}
                                        {:in '(if (> 3 1)
                                                "a"
                                                "b") 
                                         :out "\"a\""}
                                        {:in '(if (< 5 2)
                                                "a"
                                                "b") 
                                         :out "\"b\""}
                                        {:in '(if (> (+ 1 2)
                                                     (+ 5 4))
                                                (+ 5 6)
                                                "c")       
                                         :out "\"c\""}]} 

                           {:name "when"
                            :type :special-form
                            :arglists [['test-expr 'result-expr]]
                            :explanation "If `test-expr` is truthy, `when` will return `result-expr`, otherwise, it will return `nil`"
                            :notes ["`when` is a 'special form', not a function; `result-expr` is only evaluated if `test-expr` is truthy (with a function, all input expressions are evaluated before the function is applied)."
                                    "Equivalent to: `(if test-expr result-expr nil)`"]
                            :examples [{:in '(when (= 1 1)
                                               true)
                                        :out true}
                                       {:in '(when (not= 1 1)
                                               true)
                                        :out nil}]}

                           {:name "case"
                            :type :special-form
                            :arglists [['expression '& 'test-constant 'result-expression]]
                            :explanation "Takes an expression and a set of of test-constant / result-expression pairs.\n\nIf expression is equal to a test-constant, the corresponding result-expression is returned."
                            :notes ["`case` is a 'special form', not a function; only the matching `result-expression` is evaluated (with a function, all input expressions are evaluated before the function is applied)."
                                    "A default expression can be provided"
                                    "The `test-constants` can be of different types"
                                    "Can use a list as a `test-constant` to match on multiple things."
                                    "If no default is provided, and no `test-constant` matches, an exception is thrown."]
                            :examples [{:in
                                        '(let [color :g]
                                           (case color 
                                             :r "red"
                                             :g "green"
                                             :b "blue"))
                                        :out "\"green\""}
                                       {:in '(let [letter "x"]
                                               (case letter
                                                 "a" 10
                                                 "b" 23
                                                 "c" 15
                                                 0))
                                        :out 0}
                                       {:in '(let [n 5]
                                               (case n
                                                 (8 9 10) :high
                                                 (5 6 7) :medium
                                                 :low))
                                        :out :medium}]}


                           {:name "cond"
                            :type :special-form
                            :arglists [['& 'test 'expression]]
                            :explanation "Takes a set of test / expression pairs. It evaluates each test one at a time. If a test returns a truthy value, cond evaluates and returns the value of the corresponding expression and doesn't evaluate any of the other `tests` or `expressions`."
                            :notes ["`cond` is a 'special form', not a function; only the matching `expression` is evaluated (with a function, all input expressions are evaluated before the function is applied)."
                                    "To provide a default, it is common to use `:else` as a final `test` (because `:else` is truthy)"]
                            :examples [{:in '(let [grade 85]
                                               (cond
                                                 (>= grade 90) :A
                                                 (>= grade 80) :B
                                                 (>= grade 70) :C
                                                 (>= grade 60) :D
                                                 :else :F))
                                        :out :B}
                                       {:in '(let [grade 50]
                                               (cond
                                                 (>= grade 90) :A
                                                 (>= grade 80) :B
                                                 (>= grade 70) :C
                                                 (>= grade 60) :D
                                                 :else :F))
                                        :out :F}]}]}]}






   {:title "Strings"
    :sections [

               {:name "create"
                :concepts [

                           {:name "\" \""
                            :type :literal
                            :examples [{:in "\"Hello World\""}]}

                           {:name #'str
                            :type :function
                            :uses ["To convert a non-string to a string"
                                   "To create strings from multiple values"]
                            :examples [{:in '(str 10)
                                        :out "\"10\""}
                                       {:in '(let [name "Bob"]
                                               (str "My name is" name))}]}]}



               {:name "examine"
                :concepts [

                           {:name #'count
                            :type :function
                            :examples [{:in '(count "Hello World")
                                        :out 11}]}

                           {:name #'get
                            :type :function
                            :examples [{:in '(get "Hello World" 4)
                                        :out "\"o\""}]}]}



               {:name "change"
                :concepts [

                           {:name #'clojure.string/reverse
                            :type :function
                            :examples [{:in '(clojure.string/reverse "Hello World")
                                        :out "\"dlroW olleH\""}]}

                           {:name #'clojure.string/join
                            :type :function
                            :examples [{:in '(clojure.string/join ", " ["Alice" "Bob" "Cathy"])
                                        :out "\"Alice, Bob, Cathy\""}]}

                           {:name #'clojure.string/split
                            :type :function
                            :examples [{:in '(clojure.string/split "Hello my name is Bob" " ")
                                        :out ["Hello" "my" "name" "is" "Bob"]}]}

                           {:name #'clojure.string/replace
                            :type :function
                            :examples [{:in '(clojure.string/replace "Hello my name is Bob" "Bob" "Cathy")
                                        :out "\"Hello my name is Cathy\""}]}

                           {:name #'clojure.string/trim
                            :type :function
                            :examples [{:in '(clojure.string/trim "    Hello World     ")
                                        :out "\"Hello World\""}]}]}


               {:name "change case"
                :concepts [
                           {:name #'clojure.string/upper-case
                            :type :function
                            :examples [{:in '(clojure.string/upper-case "Hello World")
                                        :out "\"HELLO WORLD\""}]}

                           {:name #'clojure.string/lower-case
                            :type :function
                            :examples [{:in '(clojure.string/lower-case "Hello World")
                                        :out "\"hello world\""}]}

                           {:name #'clojure.string/capitalize
                            :type :function
                            :examples [{:in '(clojure.string/capitalize "hello world")
                                        :out "\"Hello world\""}]}]}

               {:name "test"
                :concepts [

                           {:name #'clojure.string/blank?
                            :type :function
                            :examples [{:in '(clojure.string/blank? "    ")
                                        :out true}
                                       {:in '(clojure.string/blank? "Hello World")
                                        :out false}]}

                           {:name #'clojure.string/includes?
                            :type :function
                            :examples [{:in '(clojure.string/includes? "Hello World" "e")
                                        :out true}
                                       {:in '(clojure.string/includes? "Hello World" "xyz")
                                        :out false}]}]}



               {:name "regex"
                :concepts [
                           {:name "#\" \""
                            :type :literal
                            :examples [{:in #"^a[a-z]{3}$"}]}

                           {:name #'re-matches
                            :type :function
                            :examples [{:in '(re-matches #"^a[a-z]{3}$" "abcd")
                                        :out "\"abcd\""}
                                       {:in '(re-matches #"^a([a-z]{3})$" "abcd")
                                        :out ["abcd" "bcd"]}
                                       {:in '(re-matches #"^[a-z]{4}$" "1234")
                                        :out nil}]}

                           {:name #'re-find
                            :type :function
                            :examples [{:in '(re-find #"[0-9]{3}" "abc123xyz456")
                                        :out "\"123\""}
                                       {:in '(re-find #"[a-z]{3}([0-9]{3})" "abc123xyz456")
                                        :out ["abc123" "123"]}
                                       {:in '(re-find #"[0-9]{3}" "abcdef")
                                        :out nil}]}

                           {:name #'re-seq
                            :type :function
                            :examples [{:in '(re-seq #"[0-9]{3}" "abc123xyz456")
                                        :out '("123" "456")}
                                       {:in '(re-seq #"[0-9]{3}" "abcdefg")
                                        :out nil}
                                       {:in '(re-seq #"([a-z]{3})([0-9]{3})" "abc123xyz456")
                                        :out '(["abc123" "abc" "123"] ["xyz456" "xyz" "456"])}]}

                           {:name #'re-pattern
                            :type :function
                            :examples [{:in '(re-pattern "abcdef")
                                        :out #"abcdef"}]}

                           {:name #'replace
                            :type :function
                            :examples [{:in '(clojure.string/replace "my postal code is a2c 3d4" #"\w\d\w ?\d\w\d" "XXX-XXX")
                                        :out "my postal code is XXX-XXX"}]}]}]}
                                       ; TODO examples using fn for replacement
                                       ; TODO examples using $1 in replacement

   {:title "Vectors"
    :aka "Arrays"
    :sections [ {:name "create"
                 :concepts [

                            {:name "[ ]"
                             :type :literal
                             :examples [{:in '[1 2 3 4 5]}
                                        {:in '["a" "b" "cde"]}]
                             :exercises []}]}
                                         ; TODO representing lists


               {:name "inspect"
                :concepts [
                           {:name #'count
                            :type :refer-to
                            :explanation "See `count` under Lists"}]}

               {:name "extract"
                :concepts [
                           {:name #'first
                            :type :refer-to
                            :explanation "See `first` under Lists"}

                           {:name #'last
                            :type :refer-to
                            :explanation "See `last` under Lists"}

                           {:name #'rand-nth
                            :type :refer-to
                            :explanation "See `rand-nth` under Lists"}

                           {:name #'get
                            :type :function
                            :examples [{:in '(get [:a :b :c] 0)
                                        :out :a}
                                       {:in '(get [:a :b :c] 2)
                                        :out :c}
                                       {:in '(get [:a :b :c] 5)
                                        :out nil}]}]}

               {:name "reorder"
                :concepts [

                           {:name #'shuffle
                            :type :refer-to
                            :explanation "See `shuffle` under Lists"}

                           {:name #'reverse
                            :type :refer-to
                            :explanation "See `reverse` under Lists"}

                           {:name #'sort
                            :type :refer-to
                            :explanation "See `sort` under Lists"}]}


               {:name "longer"
                :concepts [

                           {:name #'conj
                            :type :function
                            :notes ["conj works on both lists and vectors, but differently; for vectors, conj adds the value to the *end* of the vector, but with lists, conj adds the value to the *beginning*"]
                            :examples [{:in '(conj [1 2 3] 4)
                                        :out [1 2 3 4]}]}



                           {:name #'concat
                            :type :refer-to
                            :explanation "See `concat` under Lists"}]}


               {:name "shorter"
                :concepts [
                           {:name #'rest
                            :type :refer-to
                            :explanation "See `rest` under Lists"}

                           {:name #'drop
                            :type :refer-to
                            :explanation "See `drop` under Lists"}

                           {:name #'drop-last
                            :type :refer-to
                            :explanation "See `drop-last` under Lists"}

                           {:name #'take
                            :type :refer-to
                            :explanation "See `take` under Lists"}

                           {:name #'take-last
                            :type :refer-to
                            :explanation "See `take-last` under Lists"}

                           {:name #'take-while
                            :type :refer-to
                            :explanation "See `take-while` under Lists"}

                           {:name #'filter
                            :type :refer-to
                            :explanation "See `filter` under Lists"}

                           {:name #'remove
                            :type :refer-to
                            :explanation "See `remove` under Lists"}]}


               {:name "change"
                :concepts [

                           {:name #'assoc
                            :type :function
                            :notes ["Index must be in bounds of existing vector"]
                            :uses ["Rarely used"]
                            :examples [{:in '(assoc [:a :b :c] 2 :x)
                                        :out [:a :b :x]}]}

                           {:name #'map
                            :type :refer-to}

                           {:name #'map-indexed
                            :type :refer-to}

                           {:name #'reduce
                            :type :refer-to}]}

               {:name "test"
                :concepts [

                           {:name #'some
                            :type :refer-to}

                           {:name #'every?
                            :type :refer-to}

                           {:name #'empty?
                            :type :refer-to}]}]}




   {:title "Lists"
    :sections [
               {:name "create"
                :concepts [

                           {:name "'( )"
                            :type :literal
                            :examples [{:in "'(1 2 3 4 5)"}
                                       {:in "'(\"a\" \"b\" \"cde\")"}]
                            :exercises []}
                                        ; TODO representing lists


                           {:name #'range
                            :type :function
                            :examples [{:in '(range 1 5)
                                        :out '(1 2 3 4 5)}
                                       {:in '(range 0 10 2)
                                        :out '(0 2 4 6 8)}]}

                           {:name #'repeat
                            :type :function
                            :examples [{:in '(repeat 5 :a)
                                        :out '(:a :a :a :a :a)}]}]}



               {:name "inspect"
                :concepts [

                           {:name #'count
                            :type :function
                            :examples [{:in '(count [:a :b :c :d :e])
                                        :out 5}
                                       {:in '(count [])
                                        :out 0}]}]}



               {:name "extract"
                :concepts [


                           {:name #'first
                            :type :function
                            :examples [{:in '(first [1 2 3 4])
                                        :out 1}]}

                           {:name #'last
                            :type :function
                            :examples [{:in '(last [1 2 3 4])   
                                        :out 4}]}



                           {:name #'rand-nth
                            :type :function
                            :examples [{:in '(rand-nth [:a :b :c])
                                        :out :b}
                                       {:in '(rand-nth [:a :b :c])
                                        :out :a}]}]}



               {:name "reorder"
                :concepts [

                           {:name #'shuffle
                            :type :function
                            :notes ["Returns a vector, even if given a list"]
                            :examples [{:in '(shuffle [:a :b :c :d :e])
                                        :out [:a :c :d :e :b]}]}

                           {:name #'reverse
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(reverse [:a :b :c :d :e])
                                        :out '(:e :d :c :b :a)}]}

                           {:name #'sort
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(sort [5 1 2 4 3])
                                        :out '(1 2 3 4 5)}]}]}

               {:name "longer"
                :concepts [

                           {:name #'conj
                            :type :function
                            :notes ["conj works on both lists and vectors, but differently; for vectors, conj adds the value to the *end* of the vector, but with lists, conj adds the value to the *beginning*"]
                            :examples [{:in '(conj [1 2 3] 4)
                                        :out [1 2 3 4]}]}

                           {:name #'concat
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(concat [1 2 3] [4 5 6])
                                        :out '(1 2 3 4 5 6)}]}]}

               {:name "shorter"
                :concepts [
                           {:name #'rest
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(rest [1 2 3 4])
                                        :out '(2 3 4)}]}

                           {:name #'drop
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(drop 2 [:a :b :c :d :e])
                                        :out '(:c :d :e)}]}

                           {:name #'drop-last
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(drop-last 2 [:a :b :c :d :e])
                                        :out '(:a :b :c)}]}

                           {:name #'take
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(take 2 [:a :b :c :d :e])
                                        :out '(:a :b)}]}

                           {:name #'take-last
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(take-last 2 [:a :b :c :d :e])
                                        :out '(:d :e)}]}

                           {:name #'take-while
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(take-while (fn [x]
                                                           (< x 3))
                                               [1 2 0 1 2 3 2 1 5])
                                        :out '(1 2 0 1 2)}]}

                           {:name #'filter
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in '(filter (fn [x]
                                                       (> x 3))
                                               [1 2 3 4 5 6])
                                        :out '(4 5 6)}
                                       {:in '(filter (fn [n]
                                                       (> (count n) 3))
                                               ["Alice" "Bob" "Cathy" "Donald"])
                                        :out '("Alice" "Cathy" "Donald")}]}

                           {:name #'remove
                            :type :function
                            :notes ["The opposite of `filter`"
                                    "Returns a list, even if given a vector"]
                            :examples [{:in '(remove (fn [x]
                                                       (> x 3))
                                               [1 2 3 4 5 6])
                                        :out '(1 2 3)}]}]}

               {:name "change"
                :concepts [

                           {:name #'map
                            :type :function
                            :notes ["Returns a list, even if given a vector"]
                            :examples [{:in  '(map inc [1 2 3 4 5])
                                        :out '(2 3 4 5 6)}
                                       {:in '(map even? [1 2 3 4 5])
                                        :out '(false true false true false)}
                                       {:in '(map reverse ["Alice" "Bob" "Cathy" "Donald"])
                                        :out '("ecilA" "boB" "yhtaC" "dlanoD")}
                                       {:in '(map (fn [n]
                                                    (get n 2))
                                                  ["Alice" "Bob" "Cathy" "Donald"])
                                        :out '("i" "b" "t" "n")}]}

                           {:name #'map-indexed
                            :type :function
                            :notes ["Like `map`, but with an additional argument to `f` that is the index"
                                    "Returns a list, even if given a vector"]
                            :examples [{:in '(map-indexed (fn [index n]
                                                            (get n index))
                                                          '["Alice" "Bob" "Cathy" "Donald"])
                                        :out '("A" "o" "t" "a")}]}

                           {:name #'reduce
                            :type :function
                            :notes ["Can be used to re-implement most other array functions, like `filter`, `map`, etc."]
                            :examples [{:in '(reduce + [1 2 3 4 5])
                                        :out 15}
                                       {:in '(let [numbers [3 4 8 3 4 9 7 10 10]]
                                               (reduce (fn [m i]
                                                         (if-let [v (get m i)]
                                                           (assoc m i (+ 1 v))
                                                           (assoc m i 1)))
                                                       {} 
                                                       numbers))
                                        :out {3 2
                                              4 2
                                              7 1
                                              8 1
                                              9 1}}]}]}



               {:name "test"
                :concepts [

                           {:name #'some
                            :type :function
                            :uses ["Inside an `if` or `filter`, to check if any items in a collection meet a condition"
                                   "With a set, to check if collection contains a certain item"]
                            :examples [{:in '(some even? [1 2 3])
                                        :out true}
                                       {:in '(some even? [])
                                        :out nil}
                                       {:in '(some #{:x} [:a :b :c :x])
                                        :out :x}
                                       {:in '(some #{:x :y :z} [:a :b :c :x :y])
                                        :out :x}]}

                           {:name #'every?
                            :type :function
                            :examples [{:in '(every? even? [1 2 3])
                                        :out false}
                                       {:in '(every? even? [2 4 6])
                                        :out true}]}

                           {:name #'empty?
                            :type :function
                            :examples [{:in '(empty? [])
                                        :out true}
                                       {:in '(empty? [1 2 3])
                                        :out false}]}]}]}






   {:title "Maps"
    :aka "Dictionaries"
    :sections [
               {:name "create"
                :concepts [

                           {:name "{ }"
                            :type :literal
                            :notes ["keys and values; typically use keywords for keys"]
                            :uses ["To represent objects with various properties"]
                            :examples [{:in {:a 10
                                             :b 2
                                             :c 33}}
                                       {:in {:name "Bob"
                                             :email "bob@example.com"}}
                                       {:in {"a" 1
                                             "b" 2
                                             "c" 3}}
                                       {:in {[1 2] 5
                                             "foo" [2]
                                             :key "value"}}]
                            :exercises []}]}
                                        ; TODO representing various things


               {:name "extract"
                :concepts [

                           {:name #'get
                            :type :function
                            :explanation "Returns value at key, or nil. Optionally, can provide a default value."
                            :uses ["To get information out of a single map"]
                            :examples [{:in '(get {:foo "bar" :baz "xyz"} :baz)
                                        :out "\"xyz\""}
                                       {:in '(let [m {"a" 1
                                                      "b" 5}] 
                                               (get m "a"))
                                        :out 1}
                                       {:in '(let [m {:a 1
                                                      :b 5}] 
                                               (get m :c))
                                        :out nil}
                                       {:in '(let [m {:a 1
                                                      :b 5}] 
                                               (get m :c 100))
                                        :out 100}]}

                           {:name #'select-keys
                            :type :function
                            :examples [{:in '(let [m {:a 1 :b 2 :c 3}]
                                               (select-keys m [:a :c]))
                                        :out {:a 1 :c 3}}
                                       {:in '(let [m {:a 1 :b 2 :c 3}]
                                               (select-keys m [:a :b :x]))
                                        :out {:a 1 :b 2}}]}

                           {:name #'keys
                            :type :function
                            :examples [{:in '(let [m {:a 1 :b 2 :c 3}]
                                               (keys m))
                                        :out '(:a :b :c)}]}

                           {:name #'vals
                            :type :function
                            :examples [{:in '(let [m {:a 1 :b 2 :c 3}]
                                               (vals m))
                                        :out '(1 2 3)}]}]}

               {:name "test"
                :concepts [
                           {:name #'contains?
                            :type :function
                            :diagram {:in ["a collection" "key"]
                                      :out ["true" "false"]}
                            :uses ["In an `if` or `filter`, to check if a map or set contains a value"]
                            :notes ["For vectors and lists, you will want to use `some` or convert to a set with `set`"]
                            :examples [{:in '(contains? {:a 1 :b 2} :a)
                                        :out true}
                                       {:in '(contains? {:a 1 :b 2} :c)
                                        :out false}
                                       {:in '(contains? {:a nil :b 2} :a)
                                        :out true}]}]}


               {:name "change"
                :concepts [

                           {:name #'assoc
                            :type :function
                            :explanation "Returns a new map with a new key and value assigned"
                            :examples [{:in '(let [m {:a 1
                                                      :b 5}] 
                                               (assoc m :c 9))
                                        :out {:a 1 
                                              :b 5 
                                              :c 9}}
                                       {:in '(let [m {:a 1
                                                      :b 5}] 
                                               (assoc m :b 9))
                                        :out {:a 1 
                                              :b 9}}]}

                           {:name #'dissoc
                            :type :function
                            :examples [{:in '(let [m {:a 1
                                                      :b 5}] 
                                               (dissoc m :a))
                                        :out {:b 5}}
                                       {:in '(let [m {:a 1
                                                      :b 5}] 
                                               (dissoc m :c))
                                        :out {:a 1 
                                              :b 5}}]}

                           {:name #'merge
                            :type :function
                            :examples [{:in '(let [a {:i 1 :j 2 :k 3}
                                                   b {:x 10 :y 20 :z 30}]
                                               (merge a b))
                                        :out {:i 1 :j 2 :k 3
                                              :x 10 :y 20 :z 30}}
                                       {:in '(let [a {:i 1 :j 2 :k 3}
                                                   b {:i 10 :z 30}]
                                               (merge a b))
                                        :out {:i 10 :j 2 :k 3 :z 30}}
                                       {:in '(merge {} {:a 1} {:b 2})
                                        :out {:a 1 :b 2}}]}

                           {:name #'update
                            :type :function
                            :examples [{:in '(let [m {:a 1 :b 2 :c 3}]
                                               (update m :a dec))
                                        :out {:a 0 :b 2 :c 3}}
                                       {:in '(let [m {:a 1 :b 2 :c 3}]
                                               (update m :x (fn [v]
                                                              (if v
                                                                (inc v)
                                                                1))))
                                        :out {:a 1 :b 2 :c 3 :x 1}}]}]}]}


                  


   {:title "Sets"
    :sections [
               {:name "create"
                :concepts [

                           {:name "#{ }"
                            :type :literal
                            :examples [{:in '#{:a :b :c}}]}

                           {:name #'set
                            :type :function
                            :explanation "Converts a input collection into a set"
                            :uses ["To remove duplicates from a list or vector"]
                            :examples [{:in '(set [1 2 3])
                                        :out #{1 2 3}}
                                       {:in '(set [1 2 2 2 3])
                                        :out #{1 2 3}}]}]}



               {:name "examine"
                :concepts [

                           {:name #'get
                            :type :function
                            :uses ["Rare, could be used instead of `contains?`"]
                            :examples [{:in '(get #{:a :b :c} :a)
                                        :out :a}
                                       {:in '(get #{:a :b :c} :x)
                                        :out nil}]}

                           {:name #'contains?
                            :type :function
                            :diagram {:in ["a collection" "key"]
                                      :out ["true" "false"]}
                            :uses ["In an `if` or `filter`, to check if a map or set contains a value"]
                            :notes ["For vectors and lists, you will want to use `some` or convert to a set with `set`"]
                            :examples [{:in '(contains? #{1 2 3} 1)
                                        :out true}
                                       {:in '(contains? #{1 2 3} 4)
                                        :out false}]}]}



               {:name "change"
                :concepts [

                           {:name #'conj
                            :type :function
                            :examples [{:in '(conj #{:a :b} :c)
                                        :out #{:a :b :c}}
                                       {:in '(conj #{:a :b} :a)
                                        :out #{:a :b}}]}

                           {:name #'disj
                            :type :function
                            :examples [{:in '(disj #{:a :b :c} :c)
                                        :out #{:a :b}}
                                       {:in '(disj #{:a :b :c} :x)
                                        :out #{:a :b :c}}]}]}

               {:name "ops"
                :concepts [

                           {:name #'clojure.set/union
                            :type :function
                            :examples [{:in '(clojure.set/union #{:a :b :c} #{:b :c :d})
                                        :out #{:a :b :c :d}}]}

                           {:name #'clojure.set/difference
                            :type :function
                            :examples [{:in '(clojure.set/difference #{:a :b :c :d} #{:b :c})
                                        :out #{:a :d}}]}

                           {:name #'clojure.set/intersection
                            :type :function
                            :examples [{:in '(clojure.set/intersection #{:a :b :c} #{:b :c :d})
                                        :out #{:b :c}}]}]}



               {:name "test"
                :concepts [

                           {:name #'clojure.set/subset?
                            :type :function
                            :examples [{:in '(clojure.set/subset? #{:a :b} #{:a :b :c :d})
                                        :out true}
                                       {:in '(clojure.set/subset? #{:x} #{:a :b :c :d})
                                        :out false}]}

                           {:name #'clojure.set/superset?
                            :type :function
                            :notes ["Like `subset?` but with reversed arguments"]
                            :examples [{:in '(clojure.set/superset? #{:a :b :c :d} #{:a :b})
                                        :out true}
                                       {:in '(clojure.set/superset? #{:a :b :c :d} #{:x})
                                        :out false}]}]}]}




   {:title "Nested Data Structures"
    :sections [

               {:name "create"
                :concepts [

                           {:name "[ ] { } #{ }"
                            :type :literal
                            :examples {:in '[{:name "Alice"
                                              :email "alice@example.com"
                                              :friends-with #{"Cathy"}
                                              :age 20}
                                             {:name "Bob"
                                              :email "bob@example.com"
                                              :friends-with #{}
                                              :age 21}
                                             {:name "Cathy"
                                              :email "cathy@example.com"
                                              :friends-with #{"Alice"}
                                              :age 23}]}
                            :exercises []}]}
                                        ; TODO
                                        ; provide real-world data
                                        ;  (presented in scraps, words, pictures, tables, graphs)
                                        ;   goal: represent using EDN




               {:name "examine"
                :concepts [

                           {:name #'get-in
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}]]
                                               (get-in contacts [1 :name]))
                                        :out "\"Bob\""}]}]}



               {:name "change"
                :concepts [

                           {:name #'assoc-in
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}]]
                                               (assoc-in contacts [1 :name] "Robert"))
                                        :out [{:name "Alice"
                                               :email "alice@example.com"}
                                              {:name "Robert"
                                               :email "bob@example.com"}]}]}

                           {:name #'update-in
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}]]
                                               (update-in contacts [1 :name] string/upper-case))
                                        :out [{:name "Alice"
                                               :email "alice@example.com"}
                                              {:name "BOB"
                                               :email "bob@example.com"}]}]}

                           {:name #'sort-by
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}
                                                             {:name "Andy"
                                                              :email "andy@example.com"}]]
                                               (sort-by :name contacts))
                                        :out '({:name "Alice"
                                                :email "alice@example.com"}
                                               {:name "Andy"
                                                :email "andy@example.com"}
                                               {:name "Bob"
                                                :email "bob@example.com"})}
                                       {:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}
                                                             {:name "Andy"
                                                              :email "andy@example.com"}]]
                                               (sort-by (fn [contact] (count (:name contact))) contacts))
                                        :out '({:name "Bob"
                                                :email "bob@example.com"}
                                               {:name "Andy"
                                                :email "andy@example.com"}
                                               {:name "Alice"
                                                :email "alice@example.com"})}]}

                           {:name #'group-by
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"
                                                              :company "Acme Inc."}
                                                             {:name "Bob"
                                                              :email "bob@example.com"
                                                              :company "Evil Co."}
                                                             {:name "Andy"
                                                              :email "andy@example.com"
                                                              :company "Acme Inc."}]]
                                               (group-by :company contacts))
                                        :out {"Acme Inc." [{:name "Alice"
                                                            :email "alice@example.com"
                                                            :company "Acme Inc."}
                                                           {:name "Andy"
                                                            :email "andy@example.com"
                                                            :company "Acme Inc."}]
                                              "Evil Co." [{:name "Bob"
                                                           :email "bob@example.com"
                                                           :company "Evil Co."}]}}

                                       {:in '(let [contacts [{:name "Alice"
                                                              :email "alice@example.com"}
                                                             {:name "Bob"
                                                              :email "bob@example.com"}
                                                             {:name "Andy"
                                                              :email "andy@example.com"}]]
                                               (group-by (fn [contact]
                                                           (first (contact :name))) contacts))
                                        :out {"A" [{:name "Alice"
                                                    :email "alice@example.com"}
                                                   {:name "Andy"
                                                    :email "andy@example.com"}]
                                              "B" [{:name "Bob"
                                                    :email "bob@example.com"}]}}]}


                           {:name #'filter
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :company "Acme Inc."}
                                                             {:name "Bob"
                                                              :company "Evil Co."}
                                                             {:name "Andy"
                                                              :company "Acme Inc."}]]
                                               (filter (fn [contact]
                                                         (= (contact :company) "Acme Inc.")) contacts))
                                        :out '({:name "Alice"
                                                :company "Acme Inc."}
                                               {:name "Andy"
                                                :company "Acme Inc."})}]}

                           {:name #'map
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :company "Acme Inc."}
                                                             {:name "Bob"
                                                              :company "Evil Co."}
                                                             {:name "Andy"
                                                              :company "Acme Inc."}]]
                                               (map :name contacts))
                                        :out '("Alice"
                                                "Bob"
                                                "Andy")}]}

                           {:name #'reduce
                            :type :function
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :company "Acme Inc."}
                                                             {:name "Bob"
                                                              :company "Evil Co."}
                                                             {:name "Andy"
                                                              :company "Acme Inc."}]]
                                               (reduce (fn [memo contact]
                                                         (if (memo (contact :company))
                                                           (update memo (contact :company) inc)
                                                           (assoc memo (contact :company) 1))) {} contacts))
                                        :out {"Acme Inc." 2
                                              "Evil Co." 1}}]}]}



               {:name "multiple transformations"
                :skip-index? true
                :concepts [

                           {:name ""
                            :type :other
                            :examples [{:in '(let [contacts [{:name "Alice"
                                                              :company "Acme Inc."
                                                              :years-employed 5}
                                                             {:name "Bob"
                                                              :company "Evil Co."
                                                              :years-employed 10}
                                                             {:name "Andy"
                                                              :company "Acme Inc."
                                                              :years-employed 3}]]
                                               (->> contacts
                                                    (filter (fn [contact] 
                                                              (= "Acme Inc." (contact :company))))
                                                    (sort-by :years-employed)
                                                    (map :name)))
                                        :out '("Andy" "Alice")}]}]}]}])








