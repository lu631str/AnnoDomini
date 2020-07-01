package view

import java.util.Scanner

import controller.Controller
import model.{DeckBuilder, Player, Table}
import util.Observer

case class Tui(controller: Controller) extends Observer{
  controller.add(this)

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
  def askPlayerName = {
    println("enter Player name:\n")
  }

  override def update: Unit = println(controller.tableToString)
}
