
/*
  player
  has a name
  has a hand of cards
  can take new cads
  can put a card down
  can doubt the current card order
   */
package model

import org.scalatest._
 //import scala.util.control.Breaks

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new" should {
      val player = Player("Your Name", List(Card("Test", 1800)))

      "have a name" in {
        player.name should be("Your Name")
        player.name.isInstanceOf[String] should be(true)
      }
      "have a hand" in {
        player.hand.isInstanceOf[List[Card]] should be(true)
      }
      "add a Card" in {
        player.addCard(Card("Test2", 1801)) should be (Player("Your Name:", List(Card("Test2", 1801), Card("Test", 1800))))
        player.addCard(List(Card("Test2", 1801), Card("Test3", 1802))) should be  (Player("Your Name:", List(Card("Test2", 1801),Card("Test3", 1802), Card("Test", 1800))))
      }

        "remove a Card" in {
          player.removeCard(0) should be((player.hand(0), Player("Your Name", player.hand.patch(0, Nil, 1))))
          //player.removeCard(2) should be("Out of Index")
        }

        "have a nice String representation" in {
          player.toString should be("Your Name" + player.hand.mkString(", "))
        }
        "show Hand" in {
          player.showHand should be("Your Name:\n" + Card("Test", 1800) + "\n")

        }

      }
    }
  }

