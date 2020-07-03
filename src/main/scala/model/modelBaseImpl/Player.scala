package model.modelBaseImpl

import model.PlayerInterface

case class Player(name: String, var hand: List[Card]) extends PlayerInterface {
  override def toString:String = name + hand.mkString(", ")
  def selectCard(x:Int): (Card, Player) =
    (hand(x-1), Player(name, hand.patch(x-1, Nil, 1)))
  def showHand: String = name + ":\n" + hand.mkString(", ") + "\n"
  def addCard(c: Card): Player = Player(name + ":", c :: hand)

  def addCard(c: List[Card]): Player = Player(name + ":", c ::: hand)

  def removeCard(idx: Int): (Card, Player) =(hand(idx), Player(name,hand.patch(idx,Nil,1)))

  def addCardAt(idx: Int, card: Card): Player = Player(name, hand.patch(idx, card :: Nil, 0))
}
