import model._

import scala.util.Random

case class Player(name: String, hand: List[Card]) {
  override def toString: String = name

  def selectCard(x: Int) = (hand(x - 1), Player(name, hand.patch(x - 1, Nil, 1)))

  def showHand = name + ":\n" + hand.mkString(", ")

  def addCard(c: Card) = Player(name, c :: hand)

  def addCard(c: List[Card]) = Player(name, c ::: hand)

  def removeCard(idx: Int) =(hand(idx),Player(name,hand.patch(idx,Nil,1)))
}

case class Table(cards:List[Card], players:List[Player], deck:List[Card]){
  // Has to display cards
  def showCards = "Feld:\n" + cards.mkString(", ") + "\n" + players.map(p => p.showHand)
  // player draws:
  def pDraw = Table(cards, players.head.addCard(deck.head) :: players.tail, deck.tail)
  def pDraw(x:Int) = Table(cards, players.head.addCard(deck.splitAt(x-1)._1) :: players.tail, deck.splitAt(x-1)._2)
  def placeCard(idxs: Int, idxd: Int) = Table(cards.patch(idxd, List(players.head.removeCard(idxs)._1),0), players.tail:::players.head.removeCard(idxs)._2::Nil, deck)
  //def showPlayerCards = players.foreach(p => p.showCards)
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
}

class DeckBuilder{

  protected val path: String = System.getProperty("user.dir")


  // generate a deck without txt file
  def deckGen(v:Int, deck:List[Card]): List[Card] = {
    if (v < 1) {
      Nil
    } else {
      Card(s"Card $v", v) :: deckGen(v - 1, Card(s"Card $v", v) :: deck)
    }
  }
  // create deck from Textfiles

  // build deck:
  def buildDeck : List[Card] = deckGen(9, Nil)
}







val builder = new DeckBuilder
val deck = builder.buildDeck

val p = Player("p1", deck.splitAt(3)._1)
p.showHand
p.addCard(deck.head).showHand
p.addCard(deck.splitAt(2)._1).showHand

val table = Table(deck.head::Nil, Player("p1", Nil)::Nil, deck.tail)
table.showCards
table.pDraw.showCards
table.pDraw(3).showCards
table.pDraw.pDraw.placeCard(0,1)


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
