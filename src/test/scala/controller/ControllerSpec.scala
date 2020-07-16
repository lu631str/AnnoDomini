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
        controller.createRandomTable(1) should be()

      }
      "have a string presentation" in {
        controller.tableToString.isInstanceOf[String] should be(true)
      }
      "have a method to draw cards" in {
        controller.draw(1) should be(())
        controller.draw should be(())
      }
      "have a method to place a Card" in {
        controller.placeCard(0, 0) should be(())
      }
      "have a method to check the card order" in {
        controller.checkCardOrder should be(controller.table.checkCardOrder)

      }
      "have a method to get Card Text From Player" in {
        controller.getCardTextFromPlayer(0) should be(controller.table.getCardTextFromPlayer(0))

      }
      "have a method to get Card Text From cards" in {
        controller.getCardTextFromCards(0) should be(controller.table.getCardTextFromCards(0))

      }
      "have a method to  get Listleght FromCards" in {
        controller.getListleghtFromCards should be(controller.table.getListleghtFromCards)


      }
      "have a method to  get Listleght From Player" in {
        controller.getListleghtFromPlayer should be(controller.table.getListleghtFromPlayer)
      }


      "have a method to return cards" in {
        controller.returnCards should be(controller.table.returnCards)
      }

      "have a method to return Table" in {
        controller.returnTable should be(controller.table.returnTable)
      }
      "have a method to return Hand" in {
        controller.returnHand should be(controller.table.returnHand)
      }
      "have a method to return Deck" in {
        controller.returnDeck should be(controller.table.returnDeck)
      }
      "have a method to return controller" in {
        controller.returnController should be(controller)
      }
      "have a method to return name" in {
        controller.returnName should be(controller.table.returnName)
      }

      "have a method to check again the card order" in {
        controller.setCheckCardOrder should be(controller.table.setCheckCardOrder)

      }







      }
  }
}