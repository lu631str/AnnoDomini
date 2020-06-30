package model
import scala.util.control


case class Player(name: String, var hand: List[Card]) {
  override def toString:String = name + hand.mkString(", ")

  def showHand = name + ":\n" + hand.mkString(", ") + "\n"
  def addCard(c: Card) = Player(name +":" , c :: hand)

  def addCard(c: List[Card]) = Player(name + ":", c ::: hand)


  def removeCard(idx: Int): (Card, Player) = (hand(idx), Player(name, hand.patch(idx, Nil, 1)))

    /*if (idx <= hand.length) {
      println("")
    return (hand(idx), Player(name, hand.patch(idx, Nil, 1)))
  } else{
      println("Out of Index, removed first Card")
      return (hand(idx), Player(name, hand))
  }

  }
*/




}
