package controller.controllerBase

import controller.ControllerInterface
import model._
import model.modelBaseImpl.{Table, TableBuilder}
import util._
import com.google.inject.{AbstractModule, Guice, Inject}
import net.codingwell.scalaguice.ScalaModule
import net.codingwell.scalaguice.InjectorExtensions._


class Controller @Inject() (var table:TableInterface) extends ControllerInterface  {
  val undoManager = new UndoManager

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

  def setTable(table: Table): Unit = {
    this.table = table
  }

}
