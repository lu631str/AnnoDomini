import model.{Card, Player}

case class Player(name: String, hand: List[Card]) {
  override def toString:String = name
}

def deckGen(v:Int, deck:List[Card]): List[Card] = {
  if (v < 1){
    Nil
  } else {
    Card(s"Card$v", v) :: deckGen(v-1, Card(s"Card$v", v) ::deck)
  }
}
val testDeck = deckGen(10, Nil)
println(testDeck)

for(i <- 1 to 10){
  println(i)
}

testDeck.foreach(c=>println(c))

val player1 = Player("Player1", testDeck(3)::testDeck(8)::Nil)
player1.hand.foreach(c => println(c))


case class Field(cards:List[Card], players:List[Player]){
  // Has to display cards
  def showCards = cards.foreach(c => println(c))
  // has to display players
  def showPlayers = players.foreach(p => println(p))
  def showPlayerCards = players.foreach(p => println(p.hand))
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
}
testDeck(4)

val field = Field(testDeck(5)::Nil, player1::Nil)
field.cards
field.players

field.showCards
field.showPlayers
field.showPlayerCards


// testCards.foreach(println())
// I actually just want it to show the text part of the card in order,
// but putting the funktioni into the foreach doesn't work as expected
//testCards.foreach(println)
//testCards.foreach(_.look)
