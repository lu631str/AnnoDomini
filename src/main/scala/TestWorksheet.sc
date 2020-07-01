import model.{Player, _}

import scala.util.Random

case class Player(name: String, hand: List[Card]) {
  override def toString:String = name
  def selectCard(x:Int) =
    (hand(x-1), Player(name, hand.patch(x-1, Nil, 1)))
  def showHand = name + ":\n" + hand.mkString(", ") + "\n"
  def addCard(c: Card) = Player(name, c :: hand)

  def addCard(c: List[Card]) = Player(name, c ::: hand)

  def removeCard(idx: Int) =(hand(idx),Player(name,hand.patch(idx,Nil,1)))
  def addCardAt(idx: Int, card: Card) = Player(name, hand.patch(idx, card :: Nil, 0))
}

val p1 = Player("Player1", List(Card("1", 1), Card("4", 4)))
p1.showHand
p1.addCardAt(1, Card("3", 3)).showHand
p1.addCardAt(0, Card("3", 3)).showHand
