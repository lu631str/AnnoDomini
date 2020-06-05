package view

import java.util.Scanner

import controller.Controller
import model.{DeckBuilder, Player, Table}
import util.Observer

case class Tui(controller: Controller) extends Observer{
  controller.add(this)
  val scanner = new Scanner(System.in)

  println("Enter how many players want to play?")
  val players : Int = scanner.nextInt()

  controller.createRandomTable(players)
  controller.toString

  println("which Card do you want to place?")
  var card = scanner.nextInt
  println("where do you want to place it?")
  var place = scanner.nextInt

  update
  checkCards

  def checkCards = {
    if(controller.checkCardOrder){
      println("Gewonnen!")
    } else{
      println("Verloren.")
    }
  }

  override def update: Unit = println(controller.tableToString)
}
