import view._
import java.util.Scanner

import com.google.inject.Guice
import controller.ControllerInterface
import model.modelBaseImpl.{Table, TableBuilder}
import controller.controllerBase.Controller
import net.codingwell.scalaguice.InjectorExtensions._



object AnnoDomini {
  val injector = Guice.createInjector(new AnnoDominiModule())
  val controller = injector.getInstance(classOf[ControllerInterface])
  val tui : Tui = Tui(controller)
  controller.notifyObservers


  val scanner = new Scanner(System.in)
  def main(args: Array[String]): Unit = {
    println("Wilkommen bei AnnoDomini!!!")

    var input :String = ""
    println("Enter how many players want to play?")
    val players = 1 // scanner.nextInt()

    val tb = new TableBuilder
    tb.buildTable()
    controller.setTable(tb.getTable)

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
