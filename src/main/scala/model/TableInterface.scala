package model
import modelBaseImpl.{Player, Table, Card}

trait TableInterface {
  def takeacardfromplayer(idxs:Int): List[Card]
  def givecardsacard(idxs: Int, idxd:Int):List[Card]
  def returnName: String
  def returnHand: List[Card]
  def returnDeck: List[Card]
  def showCards: String
  def pDraw: Table
  def pDraw(x: Int): Table
  def placeCard(idxPlayerCard: Int, idxPositionAtTable: Int): Table
  def drawCard(x: Int): Table
  def checkCardOrder: Boolean

  def createTableBuilder: TableBuilderInterface
}

trait PlayerInterface {
  def selectCard(x:Int): (Card, Player)
  def showHand: String
  def addCard(c: Card): Player
  def addCard(c: List[Card]): Player
  def removeCard(idx: Int): (Card, Player)
  def addCardAt(idx: Int, card: Card): Player
}

trait TableBuilderInterface{
  def reset()  // suposed to set the
  def buildCards()
  def buildPlayers()
  def buildDeck()
  def buildTable()
  def getTAble()
}