package controller
import controller.controllerBase.Controller
import model._
import model.modelBaseImpl.{Card, Player, Table}
import org.scalatest._


class ControllerSpec extends WordSpec with Matchers {
  "A Controller " when {
    "new" should {
      val controller = new Controller(
        Table(
          List(Card("Test1", 1800)),
          List(Player("player 1", List(Card("Test2", 1802)))),
          List(Card("Test3", 1803))))

      "have method to generate a random Table" in {
        controller.createRandomTable(1) should be ()

      }
      "have a string presentation" in {
       controller.tableToString.isInstanceOf[String] should be (true)
      }
      "have a method to draw cards" in {
        controller.draw(1)  should be (())
        controller.draw should be (())
      }
      "have a method to place a Card" in {
        controller.placeCard(0,0) should be (())
      }
      "have a method to check the card order" in {
        controller.checkCardOrder should be (controller.table.checkCardOrder)

      }
      "have a method to get Card Text From Player" in {
        controller.getCardTextFromPlayer(0) should be(controller.table.getCardTextFromPlayer(0))

      }
    }
  }
}