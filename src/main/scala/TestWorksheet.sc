case class Card(text: String, date: Int){
  def look = s"$text"
  def reveal = s"$date"
}

var i = 20

val card1 = Card("bla", 1)

card1.look
card1.reveal

val card2 = Card("Card2", 2)
val card3 = Card("Card3", 3)

val testCards = List[Card](card1, card2, card3)

val list  = List(1, 2, 3, 4)
println(list)

list.foreach(println) // wichtig: fuznktion in funktion ohne ()!!

testCards.foreach(println)


