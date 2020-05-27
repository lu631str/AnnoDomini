import model._

import scala.util.Random

case class Player(name: String, hand: List[Card]) {
  override def toString:String = name
  def selectCard(x:Int) = (hand(x-1), Player(name, hand.patch(x-1, Nil, 1)))
  def showHand = name + ":\n" + hand.mkString(", ") + "\n"
  def addCard(c: Card) = Player(name, c :: hand)
  def addCard(c: List[Card]) = Player(name, c ::: hand)
}

case class Table(cards:List[Card], players:List[Player], deck:List[Card]){
  // Has to display cards
  def showCards = "Feld:\n" + cards.mkString(", ") + "\n" + players.map(p => p.showHand)
  // player draws:
  def pDraw = Table(
    cards,
    players.tail ::: players.head.addCard(deck.head) :: Nil,
    deck.tail)
  def pDraw(x:Int) = Table(
    cards,
     players.tail ::: players.head.addCard(deck.splitAt(x)._1) :: Nil,
    deck.splitAt(x)._2)
  //def showPlayerCards = players.foreach(p => p.showCards)
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
  //def checkCardOrder = cards.
}

val builder = new DeckBuilder
val deck = builder.buildDeck

val p = Player("p1", deck.splitAt(3)._1)
p.showHand
p.addCard(deck.head).showHand
p.addCard(deck.splitAt(2)._1).showHand

val table = Table(deck.head::Nil,
  Player("p1", Nil)::Player("p2", Nil)::Nil,
  deck.tail)
table.showCards
table.pDraw.showCards
table.pDraw(3).pDraw(2).showCards

