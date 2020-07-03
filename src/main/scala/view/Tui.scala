package view

import java.util.Scanner

import model.modelBaseImpl.DeckBuilder
import controller.ControllerInterface
import model.modelBaseImpl.{Card, DeckBuilder, Player, Table}
import model.TableInterface
import util.Observer

case class Tui(controller: ControllerInterface) extends Observer{
  controller.add(this)

  def checkCards(): Unit = {
    if(controller.checkCardOrder){
      println("Gewonnen!")
    } else{
      println("Verloren.")
    }
  }

  def placeCard(cardIndx: Int, posIndx: Int): Unit = {
    controller.placeCard(cardIndx, posIndx)
    showField()
  }

  def askForAction(): Unit ={
    println("Please enter action:")
    println("p = place a card \nd = doubt \nq = quit")
  }

  def askWhereToPlace(): Unit = {
    showField()
    println("please enter which card to place and where\n" +
      "cardIndx placeIndx")

  }

  def processInputLine(input: String): Unit ={
    input match {
      case "q" => println("Goodbye!")
      case "p" => askWhereToPlace()
      case "d" => checkCards()
      case _ => println("weird input, please enter again!")
    }
  }

  def processCardPlacement(input: String): Unit ={
    input.toInt
  }

  def showField(): Unit = println(controller.tableToString)

  override def update: Boolean = true
}
