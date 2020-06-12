package view

import java.util.Scanner

import controller._
import model._
import view._
import org.scalatest.{Matchers, WordSpec}

class TuiSpec extends WordSpec with Matchers {

  "A Game Tui" should {
    val controller = new Controller(Table(List(Card("Test1", 1800)), List(Player("player 1", List(Card("Test2", 1802)))),List(Card("Test3", 1803))))
    val tui = new Tui(controller)

    "do nothing on input 'q'" in {
    tui.processInputLine("q")
  }
    "method to check card order" in {
      tui.controller.checkCardOrder should be (true)
      tui.controller.placeCard(0,0)
      tui.checkCards should be ()

    }


  }
}
    //"create an empty Game on input 'n'" in {
    //  tui.processInputLine("n")
     // controller.game should be(Game())
    //}