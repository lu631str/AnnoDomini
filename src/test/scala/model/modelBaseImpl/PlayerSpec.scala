package modelBaseImpl

import model.modelBaseImpl.{Card, Player}
import org.scalatest._


class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your Name", List(Card("Test", 1800)))

      "have a name" in {
        player.name should be("Your Name")
        player.name.isInstanceOf[String] should be(true)

      }
      "have a hand" in {
        player.hand should be(List(Card("Test", 1800)))
        player.hand.isInstanceOf[List[Card]] should be(true)
      }
      "add a Card" in {
        player.addCard(
          Card("Test2", 1801)) should be (Player("Your Name:", List(Card("Test2", 1801), Card("Test", 1800))))
        player.addCard(List(Card("Test2", 1801), Card("Test3", 1802))) should be (Player("Your Name:", List(Card("Test2", 1801),Card("Test3", 1802), Card("Test", 1800))))
      }

        "remove a Card" in {
          //player.removeCard(0) should be((player.hand.mkString(""), Player("Your Name", player.hand.patch(0, Nil, 1))))
          //player.removeCard(2) should be("Out of Index")
          player.removeCard(0).isInstanceOf[Card] should be (false)
        }

        "have a nice String representation" in {
          player.toString should be("Your Name" + player.hand.mkString(", "))
        }
        "show Hand" in {
          player.showHand should be("Your Name:\n" + Card("Test", 1800) + "\n")

        }
      "select Card" in {
        player.selectCard(1) should be (Card("Test",1800),Player("Your Name", Nil))
        player.selectCard(1).isInstanceOf[Card] should be (false)

      }
      "addCardAt" in {
        player.addCardAt(0, Card("lala",123)).isInstanceOf[Card] should be (false)

      }



      }
    }
  }

