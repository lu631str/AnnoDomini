package controller.controllerBase

import controller.ControllerInterface
import model.modelBaseImpl.{Card, Table}
import model.{Builder, TableBuilderInterface, TableInterface}
import util._


class Controller (var table:TableInterface) extends ControllerInterface  {
  val undoManager = new UndoManager


  def createRandomTable(players:Int):Unit = {
    var tb = table.createTableBuilder
    tb.buildTable()
    //table = tb.getTable
    notifyObservers
  }

  def tableToString: String = table.showCards

  def draw(x:Int): Unit ={
    table = table.pDraw(x)
    notifyObservers

  }
  def draw(): Unit ={
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
