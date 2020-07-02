import view._
import controller._
import model._
import java.util.Scanner

import controller.Controller
import model.modelBaseImpl.Table
import controller.controllerBase.Controller


object AnnoDomini {
  val controller = new Controller(Table(Nil, Nil, Nil))
  val tui : Tui = Tui(controller)
  controller.notifyObservers
  val scanner = new Scanner(System.in)
  def main(args: Array[String]): Unit = {
    println("Wilkommen bei AnnoDomini!!!")

    var input :String = ""
    println("Enter how many players want to play?")
    val players = 1 // scanner.nextInt()

    controller.createRandomTable(players)
    do {
      tui.showField()
      tui.askForAction()
      input = scanner.next()
      tui.processInputLine(input)
      if(input == "p"){
        println("which Card do you want to place?")
        var card = scanner.nextInt
        println("where do you want to place it?")
        var place = scanner.nextInt
        tui.placeCard(card, place)
      }
      tui.update
    } while(input != "q")
  }
}
