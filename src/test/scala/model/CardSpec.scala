package model

import org.scalatest._

/*
a card
can display the date (with the text?)
  a Player is not allowed to look at the date of his cards
  the date of a card can only be revealed through doubting

 */
// to ignore a  test change the 'in' into 'ignore'
// the test will be ignored but the coverage will be registered

class CardSpec extends WordSpec  with Matchers{
  // Note the Matcher connotation is outdated,
  // it will still work but it will throw warnings
  // TODO: look up new proper syntax for the Matchers
  "A Card" when { "new" should {
    val card = model.Card("A Text", 2)
    "be an instance of Card" in{
      card.isInstanceOf[Card] should be(true)
    }
    "have a text, which is a String describing a historical event" in{
      card.text should be("A Text")
      card.text.isInstanceOf[String] should be(true)
    }
    "have a method look, which shows only its text" in{
      card.look should be("A Text")
    }
    "has a date" in {
      card.date should be(2)
      card.date.isInstanceOf[Int] should be(true)
    }
    "have a method reveal, which shows only its date" in{
      card.reveal should be("2")
    }
    "have a nice String representation" in {
      card.toString should be("A Text")
    }
  }}

}



