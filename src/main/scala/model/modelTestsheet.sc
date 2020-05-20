import model.Card

var i = 20

val a = Array(1,2,3,4)
a(1)
a(1) = 4
a

val card1 = Card("bla", 1)


card1.look
card1.reveal

val card2 = Card("Card2", 2)
val card3 = Card("Card3", 3)

val testCards = List[model.Card](card1, card2, card3)



// testCards.foreach(println())
// I actually just want it to show the text part of the card in order,
// but putting the funktioni into the foreach doesn't work as expected
testCards.foreach(println)
testCards.foreach(_.look)


