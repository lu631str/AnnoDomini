import model._

import scala.util.Random

case class Player(name: String, hand: List[Card]) {
  def showCards = hand.foreach(card => s"$card")
  def showPlayer = s"$name"
  override def toString:String = name
}


case class Field(cards:List[Card], players:List[Player]){
  // Has to display cards
  def showCards = cards.foreach(c => println(c))
  // has to display players
  def showPlayers = players.foreach(p => println(s"$p" + p.showCards))
  def showPlayerCards = players.foreach(p => p.showCards)
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
}
val builder = new DeckBuilder
val deck = builder.buildDeck

deck.deck
deck.draw
deck.draw(2)


val deck2 = deck.shuffle
deck2.deck

val player = Player("p1", deck.draw(2)._1)
player.hand


/*
val field = Field(testDeck(5)::Nil, player1::player2::Nil)
field.cards
field.players

field.showCards
field.showPlayers
field.showPlayerCards
*/

// testCards.foreach(println())
// I actually just want it to show the text part of the card in order,
// but putting the funktioni into the foreach doesn't work as expected
//testCards.foreach(println)
//testCards.foreach(_.look)
