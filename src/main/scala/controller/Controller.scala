package controller

import model._
import util._


class Controller(var table:Table) extends Observable {

  def createEmptyTable(size: Int):Unit = {
    table = Table(Nil, Nil, Nil)
    notifyObservers
  }

  def createRandomTable(players:Int):Unit = {
    val db = new DeckBuilder
    val deck = db.buildDeck
    table = Table(
      deck.head::Nil,
      Player("player1", deck.tail.splitAt(3)._1)::Nil,
      deck.tail)
    /*for(p <- 1 to players){
      table = table(
        table.cards,
        Player(
          "player"+s"$p",
          table.deck.splitAt(3)._1)::table.players,
        table.deck.splitAt(3)._2)
    }*/

    notifyObservers
  }

  def gridToString: String = Table.toString

  def draw(x:Int) ={
    table = table.pDraw(x)
    notifyObservers

  }
  def draw ={
    table = table.pDraw
    notifyObservers
  }

  def placeCard(cardIdx:Int, position:Int) = {
    table = table.placeCard(cardIdx, position)
    notifyObservers
  }

  def checkCardOrder = {
    table.checkCardOrder
    notifyObservers
  }


}