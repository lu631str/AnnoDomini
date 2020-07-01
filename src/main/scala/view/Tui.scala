package view

import java.util.Scanner

import controller.Controller
import model.{Card, DeckBuilder, Player, Table}
import util.Observer

case class Tui(controller: Controller) extends Observer{
  controller.add(this)

  def checkCards() = {
    if(controller.checkCardOrder){
      println("Gewonnen!")
    } else{
      println("Verloren.")
    }
  }

  def placeCard(cardIndx: Int, posIndx: Int): Unit = {
    controller.placeCard(cardIndx, posIndx)
    showField
  }

  def processInputLine(input: String): Unit ={
    input match {
      case "q" =>
      //case _._ => controller.placeCard(_, _)
    }
  }

  def showField(): Unit = println(controller.tableToString)

  override def update: Boolean = true
}
