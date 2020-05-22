package model

case class Field(cards:List[Card], players:List[Player]){
  // Has to display cards
  def showCards = cards.foreach(c => println(c))
  // has to display players
  def showPlayers = players.foreach(p => println(p))
  def showPlayerCards = players.foreach(p => println(p.hand))
  // has to allow a player to place a card
  // has to be able to check a if the card order is correct
}
