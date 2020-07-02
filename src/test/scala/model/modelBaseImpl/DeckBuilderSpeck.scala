package modelBaseImpl


import model.modelBaseImpl.{Card, DeckBuilder}
import org.scalatest._


 /* the DeckBuilder is a class, that's supposed to create
  a playable Deck.
  First it is supposed to generate cards from a txt file
  and store them in a list
  then it is supposed to create a randomzied list with
  all those cards
  Then it builds an instance of the Deck class with this
  randomized list.
  We could also create a test version, in which the deck is
  'shuffeld' in a preidctable way.
  The game contains different versions with different themes.
  The deckbuilder can choose between those different versions
  or combine them together.
*/

class DeckBuilderSpeck extends  WordSpec with Matchers {
  "The DeckBuilder works" when {
    "using the standard Deck" should {
      val deckBuilder = new DeckBuilder

      "have a method to generate a deck" in {
        deckBuilder.deckGen(0,Nil) should be (Nil)
        deckBuilder.deckGen(1,Nil) should be (List(Card("Card 1",1)))
      }
      "have a method to generate a deck with 9 cards"in{
        deckBuilder.buildDeck should be (deckBuilder.deckGen(9,Nil))
      }





      "contain a list of txt file names, those are the game versions chosen by the player" in{

      }
      "have a method built, which creates the deck from the given txt files" in{
        // method should create a list of cards
        // the list of cards is as long as the amount of lines in a given txt file
        // the created cards have to be properly formated
        // it cannot contain the same card twice
      }
      "have a method shuffle, which creates a randomized version of the deck" in {
        // the shuffled deck should have as many cards as the new one
        // the shuffled deck cannot contain the same card twice
        // the shuffled deck has to be actually randomized (kinda hard to test, isn't it?)
      }
         }
  }

}
