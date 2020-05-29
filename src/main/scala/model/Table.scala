package model

case class Table(cards:List[Card], players:List[Player], deck:List[Card]){
  // Has to display cards
  def showCards = "Feld:\n" +
    cards.mkString(", ") + "\n" + players.map(p => p.showHand).mkString("\n")
  // player draws:
  def pDraw = Table(
    cards,
    players.tail ::: players.head.addCard(deck.head) :: Nil,
    deck.tail)
  def pDraw(x:Int) = Table(
    cards,
    players.tail ::: players.head.addCard(deck.splitAt(x)._1) :: Nil,
    deck.splitAt(x)._2)
  def placeCard(idxs: Int, idxd: Int) = Table(
    cards.patch(idxd, List(players.head.removeCard(idxs)._1),0),
    players.tail:::players.head.removeCard(idxs)._2::Nil, deck)

  //def showPlayerCards = players.foreach(p => p.showCards)
  // has to allow a player to place a card

  // has to be able to check a if the card order is correct
  def checkCardOrder: Boolean = cards.head.date < cards.tail.head.date
}