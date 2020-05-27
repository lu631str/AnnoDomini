import model._

object AnnoDomini {
    def main(args: Array[String]): Unit = {
      println("Wilkommen bei AnnoDomini!!!")
      val card1 = Card("Mauerfall", 1989)
      val card2 = Card("Anfang zweiter Weltkrieg", 1939)

      // generate deck
      val deckBuilder = new DeckBuilder

      // for now lets just make 9 cards,
      // with the dates 1-5 and text being "Card1" to "Card10"
      val deck = deckBuilder.buildDeck

      // we probably could realize a complete deck by typing the cardvalues into a txt document
      // and using a function to translate the string into cards
      // generate players
      // so we definetly need a way to input
      //val player1 = Player("Lukas", testDeck(1)::testDeck(4)::Nil)
      //println("Hello, " + player1.name)
      // ask for second player
      // val player2 = Player("Sarah", )
      // ask for more players

      // generate a field, which takes a random card from the deck




    }

}
