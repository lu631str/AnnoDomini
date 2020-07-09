package controller
import controller.controllerBase.Controller
import model._
import model.modelBaseImpl.{Card, Table}
import util._

import scala.swing.Publisher
import scala.swing._
import scala.swing.event.Event

trait ControllerInterface extends Publisher {


  def createRandomTable(players: Int)

  def tableToString: String

  def draw(x: Int)

  def draw

  def placeCard(cardIdx: Int, position: Int)

  def getListleghtFromPlayer: Int

  def getListleghtFromCards: Int

  def returnHand: List[Card]

  def returnController: Controller

  def givecardsacard(idxs:Int, idxd:Int): List[Card]

  def takeacardfromplayer(idxs:Int): List[Card]

  def returnTable:Table

  def returnDeck: List[Card]

  def returnName:String

  def doStep(p:    PlayerPlaceCommand): Unit

  def returnCards: List[Card]

  def checkCardOrder: Boolean

  def undo()

  def redo()

  def getCardTextFromPlayer(idx: Int): String

  def getCardTextFromCards(idx: Int): String


  import scala.swing.event.Event

}

  class creat extends Event
  class GameChange extends Event








