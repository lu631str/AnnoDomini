package model
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
      val deck = Deck
      "have a list of cards" in{
        // check list type
      }
      "have a method shuffle" in{
        // use shuffle
        // the new deck has to have the same length as the old one
        // the new deck has to be different from the old one
        // to ensure randomness shuffle 10 times, then compare them
        // they should all be different from one another
      }
      "have a method draw" in{
        // use draw
        // the newDeck.length = oldDeck.length -1
        // newDeck = oldDeck.tail
      }
    }
  }

}
