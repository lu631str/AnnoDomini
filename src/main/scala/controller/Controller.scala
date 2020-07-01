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

  def tableToString: String = table.toString  //TODO: properly define the to String method

  def draw(x:Int) ={
    table = table.pDraw(x)
    notifyObservers

  }
  def draw ={
    table = table.pDraw
    notifyObservers
  }

  def placeCard(cardIdx:Int, position:Int) = {
    table = table.placeCard(cardIdx, position)
    notifyObservers
  }

  def checkCardOrder = {
    notifyObservers
    table.checkCardOrder
  }

  def undo: Unit ={
    undoManager.undoStep
    notifyObservers
  }

  def redo: Unit ={
    undoManager.redoStep
    notifyObservers
  }


}
