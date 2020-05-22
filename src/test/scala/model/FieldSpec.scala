package model
import org.scalatest._

class FieldSpec extends WordSpec with Matchers {
  "Field is the basic playing field" when{
    "new" should {
      "have a collection of ordered cards" in{


      }
      "have at least one player" in{

      }
      "have a method place, which places a players card on the table" in {

      }
      "have a method check, which checks whether the card.dates are in the right order" in{

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
