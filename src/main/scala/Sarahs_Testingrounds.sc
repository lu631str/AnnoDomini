/*
  The following Worksheet will contain definitions,
  that aren'T necessarily relevant to the game but Sarah wanted to try out
 */

val list  = List(1, 2, 3, 4)
println(list)

list.foreach(println) // wichtig: fuznktion in funktion ohne ()!!

val sum = (x:Double, y:Double) => x + y //example for lamdaexpression in scala
sum(2, 2)
sum(3, 6)
sum(2.4, 1.7)