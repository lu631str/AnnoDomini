package model.modelBaseImpl
import org.scalatest._
class TableBuilderSpec extends WordSpec with Matchers {
  "A Table" when {
    "new" should {
      val tableBuilder = new TableBuilder

      "have a deck" in {
      tableBuilder.deck.isInstanceOf[List[Card]] should be (true)

      }

      "have a cards" in {
        tableBuilder.cards.isInstanceOf[List[Card]] should be (true)

      }

      "have a players" in {
        tableBuilder.players.isInstanceOf[List[Player]] should be (true)

      }
      "have a method reset" in {
        tableBuilder.reset()  should be ()

      }
      "have a method buildDeck" in {
        tableBuilder.buildDeck()  should be ()

        }
       " have a method buildPlayers" in {
        tableBuilder.buildPlayers()  should be ()

        }
       " have a method buildCards" in {
        tableBuilder.buildCards()  should be ()

        }
        "have a method buildTable" in {
        tableBuilder.buildTable()  should be ()

        }

      "have a method getTable" in {
        tableBuilder.getTable should be (Table(tableBuilder.cards, tableBuilder.players, tableBuilder.deck))

        }




    }
  }
}