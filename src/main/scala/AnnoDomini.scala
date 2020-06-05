import view._
import controller._
import model._
import java.util.Scanner

import controller.Controller


object AnnoDomini {
  val controller = new Controller(Table(Nil, Nil, Nil))
  val tui = new Tui(controller)
  controller.notifyObservers
  val scanner = new Scanner(System.in)
  def main(args: Array[String]): Unit = {
    println("Wilkommen bei AnnoDomini!!!")

    var input :String = ""
    println("Enter how many players want to play?")
    val players = scanner.nextInt()
    controller.createRandomTable(players)
    tui.update
    do {
      input = scanner.nextLine()
      tui.processInputLine(input)
      tui.update

    } while(input != "q")
  }
}
