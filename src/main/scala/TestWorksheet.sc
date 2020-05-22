import model.{Card, Player}

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


case class Player(name: String, cards: List[Card]) {
  override def toString:String = name
}

val player1 = Player("Lukas", List(card1, card2))

  val test = player1.cards
  print(test)

def deckGen(v:Int, deck:List[Card]): List[Card] = {
  if (v < 1){
    Nil
  } else {
    Card(s"Card $v", v) :: deckGen(v-1, Card(s"Card $v", v) ::deck)
  }
}

val testDeck = deckGen(10, Nil)
println(testDeck)


for(i <- 1 to 10){
  println(i)
}


case class Field(cards:List[Card], players:List[Player]){
  // Has to display cards
  def showCards = cards.foreach(c => println)
  // has to display players
  def showPlayers = players.foreach(p => println)
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
}
// testCards.foreach(println())
// I actually just want it to show the text part of the card in order,
// but putting the funktioni into the foreach doesn't work as expected
//testCards.foreach(println)
//testCards.foreach(_.look)


