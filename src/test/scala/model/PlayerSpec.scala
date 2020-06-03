
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

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val player = Player("Your Name", List(Card("Test", 1800)))
    "have a name"  in {
      player.name should be("Your Name")
      player.name.isInstanceOf[String] should be(true)
    }
    "have a hand" in {
      player.hand.isInstanceOf[List[Card]] should be(true)

    }

    "shows Hand" in {
      player.showHand should be("Your Name:\n" + Card("Test", 1800) + "\n")

    }


    "have a nice String representation" in {
      player.toString should be("Your Name" + player.hand.mkString(", "))
    }
    "shows Hand" in {
      player.showHand should be("Your Name:\n" + Card("Test", 1800) + "\n")

    }

  }}
}
