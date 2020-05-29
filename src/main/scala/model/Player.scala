package model

case class Player(name: String, hand: List[Card]) {
  override def toString:String = name
  def selectCard(x:Int) =
    (hand(x-1), Player(name, hand.patch(x-1, Nil, 1)))
  def showHand = name + ":\n" + hand.mkString(", ") + "\n"
  def addCard(c: Card) = Player(name, c :: hand)

  def addCard(c: List[Card]) = Player(name, c ::: hand)

  def removeCard(idx: Int) =(hand(idx),Player(name,hand.patch(idx,Nil,1)))
}
