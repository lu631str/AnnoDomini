package model

import view._

class TableBuilder extends Builder {
  // does not yet adhere to functional programming!!!
  // TODO: make functional.
  var deck : List[Card] = Nil
  var cards : List[Card] = Nil
  var players : List[Player] = Nil

  override def reset(): Unit = println("not done yet")

  override def buildCards(): Unit = {
    if(deck.isEmpty) buildDeck()
      cards = deck.head :: Nil
      deck = deck.tail
  }

  override def buildDeck(): Unit = {
    // at a later point, deckbuilder should be able to take
    // several sting values and generate different decks from them
    val db = new DeckBuilder
    deck = db.buildDeck
  }

  override def buildPlayers(): Unit = {

    // ask for player name
    val name : String= ""
    // if none given player i is default
    // create player with given name, but we need
    if(!name.isEmpty) players = Player(name, deck.head::Nil) :: Nil
    else players = Player("Player1", deck.head::Nil) :: Nil
    deck = deck.tail

  }
  def buildTable(): Unit = {
    buildDeck()
    buildCards()
    // Ask for number of players?
    buildPlayers()
  }

  def getTable: Table = Table(cards, players, deck)
}

