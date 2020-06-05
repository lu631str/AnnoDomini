import view._
import controller._
import model._
import java.util.Scanner

import controller.Controller


object AnnoDomini {
  val controller = new Controller(Table(Nil, Nil, Nil))
  val tui = new Tui(controller)
  def main(args: Array[String]): Unit = {
    println("Wilkommen bei AnnoDomini!!!")

  }
}
