package modelBaseImpl

import model.modelBaseImpl.{Card, CardStack, Table}
import org.scalatest._


class CardStackSpec extends WordSpec with Matchers {

  "A CardStack" when {
    "using" should {
      val cardstack = CardStack.initialize
      "a new cardstack should be declared in a Table" in {
        val table = Table(Nil, Nil, CardStack.initialize)
        table.deck.isInstanceOf[List[Card]] should be(true)
      }
    }
  }
}
