import model._
import java.util.Scanner
import scala.util.Random

object AnnoDomini {
    def main(args: Array[String]): Unit = {
      println("Wilkommen bei AnnoDomini!!!")
      val card1 = Card("Mauerfall", 1989)
      val card2 = Card("Anfang zweiter Weltkrieg", 1939)

      // generate deck
      val deckBuilder = new DeckBuilder

      // for now lets just make 9 cards,
      // with the dates 1-5 and text being "Card1" to "Card10"
      val deck = Random.shuffle(deckBuilder.buildDeck)

      var table = Table(List(deck.head), List(Player("player 1", deck.tail.splitAt(3)._1)), deck.tail.splitAt(3)._2)
      println(table.showCards)
      while(table.players.head.hand.nonEmpty){
        println("which Card do you want to place?")
        val scanner = new Scanner(System.in)
        var card = scanner.nextInt
        println("where do you want to place it?")
        var place = scanner.nextInt
        // generate a field, which takes a random card from the deck
        table = table.placeCard(card, place)
        println(table.showCards)

      }
      table.checkCardOrder
    }

}
