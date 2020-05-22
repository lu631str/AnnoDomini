package model

case class Player(name: String,hand: List[Card]) {
  override def toString:String = name
}
