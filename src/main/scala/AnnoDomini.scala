import model._

object AnnoDomini {
    def main(args: Array[String]): Unit = {
      println("Wilkommen bei AnnoDomini!!!")
      val card1 = Card("Mauerfall", 1989)
      val card2 = Card("Anfang zweiter Weltkrieg", 1939)

      // generate deck
      def deckGen(v:Int, deck:List[Card]): List[Card] = {
        if (v < 1){
          Nil
        } else {
          Card(s"Card $v", v) :: deckGen(v-1, Card(s"Card $v", v) ::deck)
        }
      }

      // for now lets just make 10 cards,
      // with the dates 1-5 and text being "Card1" to "Card10"
      val testDeck = deckGen(10, Nil)

      // we probably could realize a complete deck by typing the cardvalues into a txt document
      // and using a function to translate the string into cards
      // generate players
      // so we definetly need a way to input
      val player1 = Player("Lukas", (testDeck(1)::testDeck(4)::Nil))
      println("Hello, " + player1.name)
      // ask for second player
      // val player2 = Player("Sarah", )
      // ask for more players

      // generate a field, which takes a random card from the deck




    }

}
