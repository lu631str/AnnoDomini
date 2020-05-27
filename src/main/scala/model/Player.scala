package model

case class Player(name: String, hand: List[Card]) {
  def selectCard(x:Int): Card = hand(x-1)
  def showHand: String = hand.mkString(", ")
  override def toString:String = name
}
