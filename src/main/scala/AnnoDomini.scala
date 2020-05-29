import model._
import java.util.Scanner


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

      val table = Table(List(deck.head), List(Player("player 1", deck.tail.splitAt(3)._1)), deck.tail.splitAt(3)._2)
      println(table.showCards)

      println("which Card do you want to place?")
      val scanner = new Scanner(System.in)
      var card = scanner.nextInt
      println("where do you want to place it?")
      var place = scanner.nextInt
      // generate a field, which takes a random card from the deck
      println(table.placeCard(card, place).showCards)
      if(table.placeCard(card, place).checkCardOrder){
        println("Gewonnen!")
      } else{
        println("Verloren.")
      }
    }

}
