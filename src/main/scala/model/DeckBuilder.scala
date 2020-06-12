package model
import java.nio.file.Paths

class DeckBuilder{

 // protected val path: String = System.getProperty("user.dir")


  // generate a deck without txt file
  def deckGen(v:Int, deck:List[Card]): List[Card] = {
    if (v < 1) {
      Nil
    } else {
      Card(s"Card $v", v) :: deckGen(v - 1, Card(s"Card $v", v) :: deck)
    }
  }
  // create deck from Textfiles

  // build deck:
  def buildDeck : List[Card] = deckGen(9, Nil)
}
