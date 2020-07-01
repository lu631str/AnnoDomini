package controller

import model._
import util._


class Controller(var table:Table) extends Observable {
  val undoManager = new UndoManager


  def createRandomTable(players:Int):Unit = {
    val tb = new TableBuilder
    tb.buildTable
    table = tb.getTable
    notifyObservers
  }

  def tableToString: String = table.showCards

  def draw(x:Int): Unit ={
    table = table.pDraw(x)
    notifyObservers

  }
  def draw() ={
    table = table.pDraw
    notifyObservers
  }

  def placeCard(cardIdx:Int, position:Int): Unit = {
    table = table.placeCard(cardIdx, position)
    notifyObservers
  }

  def checkCardOrder: Boolean = {
    notifyObservers
    table.checkCardOrder
  }

  def undo(): Unit ={
    undoManager.undoStep
    notifyObservers
  }

  def redo(): Unit ={
    undoManager.redoStep
    notifyObservers
  }


}
