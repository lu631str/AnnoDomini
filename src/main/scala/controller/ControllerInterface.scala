package controller
import model._
import model.modelBaseImpl.Table
import util._

trait ControllerInterface extends Observable{


  def setTable(table: Table): Unit
  def tableToString:String
  def draw(x:Int)
  def draw
  def placeCard(cardIdx:Int, position:Int)
  def checkCardOrder:Boolean
  def undo()
  def redo()

}
