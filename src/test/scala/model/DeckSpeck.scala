/*package model
import org.scalatest._

/*
  The Deck Class is a list of cards.
  It contains the method draw, which returns the head of the list and then
  generates a new deck that lacks the drawn card.
  It contains a method shuffle, which returns a randomized version of the deck
 */

class DeckSpeck extends WordSpec with Matchers {
  "A Deck contains playable cards" when{
    "new" should {
      val deck = Deck(List(Card("Test1", 1801), Card("Test2", 1802), Card("Test3", 1803), Card("Test4", 1804), Card("Test5", 1805),Card("Test6", 1806)
      ,Card("Test7", 1807),Card("Test8", 1808),Card("Test9", 1809),Card("Test10", 1810)))

      "have a list of cards" in{
       deck.deck should be (List(Card("Test1", 1801), Card("Test2", 1802), Card("Test3", 1803), Card("Test4", 1804), Card("Test5", 1805),Card("Test6", 1806)
         ,Card("Test7", 1807),Card("Test8", 1808),Card("Test9", 1809),Card("Test10", 1810)))
         deck.deck.isInstanceOf[List[Card]] should be(true)
      }
      "have a method shuffle" in{
        deck.shuffle.deck.size should be (10)
        deck.shuffle.shuffle.shuffle should not equal  (List(Card("Test1", 1801), Card("Test2", 1802), Card("Test3", 1803), Card("Test4", 1804), Card("Test5", 1805),Card("Test6", 1806)
          ,Card("Test7", 1807),Card("Test8", 1808),Card("Test9", 1809),Card("Test10", 1810)))


      }
      "have a method draw" in{
        deck.draw
        // use draw
        // the newDeck.length = oldDeck.length -1
        // newDeck = oldDeck.tail
      }
    }
  }

}

*/
