package model
import org.scalatest._

class TabledSpec extends WordSpec with Matchers {
  "Field is the basic playing field" when{
    "new" should {
      val table = new Table(List(Card("Test1", 1800)), List(Player("player 1", List(Card("Test2", 1802)))),List(Card("Test3", 1803)))
      "have a collection of ordered cards" in{
        table.cards should be (List(Card("Test1", 1800)))
        table.cards.isInstanceOf[List[Card]] should be (true)
        table.cards should not equal(Nil)
      }
      "have at least one player" in{
        table.players should be (List(Player("player 1", List(Card("Test2", 1802)))))
        table.players.isInstanceOf[List[Player]] should be (true)
        table.players should not equal(Nil)
      }
      "have deck" in{
        table.deck should be (List(Card("Test3", 1803)))
        table.deck.isInstanceOf[List[Card]] should be (true)

      }
      //"have a method apply"in{
       // table.apply(table.cards, table.players) should be ("")

      //}





      "have a method to show cards on the 'field'" in {
        table.showCards should be ("Feld:\n" + List(Card("Test1", 1800)).mkString(", ") + "\n" + table.players.map(p => p.showHand).mkString("\n"))
      }


      "have a method place, which places a players card on the table" in {
        table.pDraw should be (Table(List(Card("Test1", 1800)), table.players.tail ::: table.players.head.addCard(table.deck.head) :: Nil,
          table.deck.tail))
        table.pDraw(1) should be (Table(List(Card("Test1", 1800)),table.players.tail ::: table.players.head.addCard(table.deck.splitAt(1)._1) :: Nil,
          table.deck.splitAt(1)._2))
      }
      "have a method to place a card on the 'board'" in{
        table.placeCard(0,0) should be (Table(
          table.cards.patch(0, List(table.players.head.removeCard(0)._1),0),
          table.players.tail:::table.players.head.removeCard(0)._2::Nil, table.deck))

      }
      "have a method check, which checks whether the card.dates are in the right order" in{
        table.checkCardOrder should be(true)
        table.placeCard(0,0).checkCardOrder should be(false)
      }
      "have a nice string presentation" in {
        table.toString should be (table.showCards)


      }
    }
  }
/*
  the field
  has laid down cards,
     there is always at least on card layed down
     the laid down cards have an order


  TUI:

   Player1:
   Card1: "der erste PC kommt auf den Markt",  Card2: text,  Card3: text

   Player2:
   Card1: text,  Card2: text,  Card3: text

   model.Field:
     Card1: text,  model.Card: text, model.Card: text

   Current Player: Player1
   what do you wanna do?

   ablegen(C1, position(C1, C2))


 */
}
