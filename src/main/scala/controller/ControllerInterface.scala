package controller
import model._
import util._

trait ControllerInterface extends Observable{


  def createRandomTable(players:Int)
  def tableToString:String
  def draw(x:Int)
  def draw
  def placeCard(cardIdx:Int, position:Int)
  def checkCardOrder:Boolean
  def undo()
  def redo()

}
