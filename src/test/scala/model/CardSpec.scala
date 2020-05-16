package model

import org.scalatest._

/*
a card
has a text, which is a String describing a historical event
has a date, which refers to the date the corresponding text-event happened
can show the text, without displaying the date
can display the date (with the text?)
  a Player is not allowed to look at the date of his cards
  the date of a card can only be revealed through doubting

 */

class CardSpec extends WordSpec  with Matchers{
  // Note the Mathcer connotation is outdated,
  // it will still work but it will throw warnings
  // TODO: look up new proper syntax for the Matchers
  "A Card" when { "new" should {
    val card = model.Card("A Text", 2)
    "have a text" in{
      card.text should be("A Text")
    }
    "have a date" in{
      card.date should be(2)
    }
    "have a nice String representation" in {
      card.toString should be("A Text")
    }
  }}


}



