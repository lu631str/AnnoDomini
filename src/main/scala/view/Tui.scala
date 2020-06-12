package view

import java.util.Scanner

import controller.Controller
import model.{DeckBuilder, Player, Table}
import util.Observer

case class Tui(controller: Controller) extends Observer{
  controller.add(this)
  val scanner = new Scanner(System.in)
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
  def processInputLine(input: String)={
    input match {
      case "q" =>
      //case _._ => controller.placeCard(_, _)
    }


  }

  override def update: Boolean= (true)
}
