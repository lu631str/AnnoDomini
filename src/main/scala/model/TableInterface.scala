package model
import modelBaseImpl.{Player, Table, Card}

trait TableInterface {
  def showCards: String
  def pDraw: Table
  def pDraw(x: Int): Table
  def placeCard(idxPlayerCard: Int, idxPositionAtTable: Int): Table
  def drawCard(x: Int): Table
  def checkCardOrder: Boolean
}

trait PlayerInterface {
  def selectCard(x:Int): (Card, Player)
  def showHand: String
  def addCard(c: Card): Player
  def addCard(c: List[Card]): Player
  def removeCard(idx: Int): (Card, Player)
  def addCardAt(idx: Int, card: Card): Player
}