package model

case class Player(name: String,cards: List[Card]) {
  override def toString:String = name
}
