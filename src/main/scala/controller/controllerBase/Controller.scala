package controller.controllerBase


import controller.{ControllerInterface, GameChange, PlayerPlaceCommand, end}
import model._
import model.modelBaseImpl.{Card, Table, TableBuilder}
import util._

import scala.swing.Publisher
import scala.swing.event.Event


class Controller (var table:TableInterface) extends ControllerInterface with Publisher  {
  val undoManager = new UndoManager


  def createRandomTable(players:Int):Unit = {
    val tb = new TableBuilder
    tb.buildTable()
    table = tb.getTable
    publish(new GameChange)
  }

  def tableToString: String = table.showCards

  def draw(x:Int): Unit ={
    table = table.pDraw(x)
    publish(new GameChange)

  }
  def draw(): Unit ={
    table = table.pDraw
    publish(new GameChange)
  }

  def getCardTextFromPlayer(idx:Int): String ={
      return table.getCardTextFromPlayer(idx)

  }
  def getCardTextFromCards(idx:Int): String={
    return table.getCardTextFromCards(idx)
  }

  def getListleghtFromPlayer: Int={
    return table.getListleghtFromPlayer

  }

   def getListleghtFromCards: Int={
    return table.getListleghtFromCards

  }
  def returnCards: List[Card] = table.returnCards

  def returnHand: List[Card] = table.returnHand

  def givecardsacard(idxs:Int, idxd:Int): List[Card] = table.givecardsacard(idxs, idxd)

  def takeacardfromplayer(idxs:Int): List[Card] = table.takeacardfromplayer(idxs)

  def returnTable:Table = return return table.returnTable

  def returnName:String = table.returnName

  def returnDeck: List[Card] = table.returnDeck

  def returnController: Controller = return this



  def placeCard(cardIdx:Int, position:Int): Unit = {
    table = table.placeCard(cardIdx, position)
    publish(new GameChange)
  }
  def setCheckCardOrder: Boolean = {
    table.setCheckCardOrder
  }

  def checkCardOrder: Boolean = {
    publish(new end)
    table.checkCardOrder

  }







  def doStep(p:    PlayerPlaceCommand): Unit ={
    undoManager.doStep( p:    PlayerPlaceCommand)
    publish(new GameChange)
  }
  def undo(): Unit ={
    undoManager.undoStep
    publish(new GameChange)
  }

  def redo(): Unit ={
    undoManager.redoStep
    publish(new GameChange)
  }


}
