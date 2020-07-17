package model.modelBaseImpl

import model.TableInterface

case class Table(cards:List[Card], players:List[Player], deck:List[Card]) extends TableInterface {

    // Has to display cards
    def showCards: String = "Feld:\n" +
      cards.mkString(", ") + "\n" + players.map(p => p.showHand).mkString("\n")

    // player draws:
    def pDraw: Table = Table(
      cards,
      players.tail ::: players.head.addCard(deck.head) :: Nil,
      deck.tail)

    //def addCard(idx:Int) = players.tail ::: players.head.addCard(cards.splitAt(idx)._1)


    def pDraw(x: Int): Table = Table(
      cards,
      players.tail ::: players.head.addCard(deck.splitAt(x)._1) :: Nil,
      deck.splitAt(x)._2)

    def placeCard(idxPlayerCard: Int, idxPositionAtTable: Int): Table = Table(
      cards.patch(idxPositionAtTable, List(players.head.removeCard(idxPlayerCard)._1), 0),
      players.tail ::: players.head.removeCard(idxPlayerCard)._2 :: Nil, deck)

    def drawCard(x: Int): Table = Table(
      cards.splitAt(x)._2, players.tail ::: players.head.addCard(cards.splitAt(x)._1) :: Nil,
      deck)

  def givecardsacard(idxs:Int, idxd:Int): List[Card] ={
    cards.patch(idxd,List(players.head.hand(idxs)) , 0)
  }

  def takeacardfromplayer(idxs:Int): List[Card] = {
    players.head.hand.patch(idxs, Nil, 1)

  }

  def returnHand: List[Card] = players.head.hand

  def returnDeck: List[Card] = deck

  def returnName:String  = {return players.head.name}

    override def toString: String = showCards

    //def showPlayerCards = players.foreach(p => p.showCards)
    // has to allow a player to place a card

    // has to be able to check a if the card order is correct
    def checkCardOrder: Boolean = {
      val sortedList = cards.sortWith(_.date < _.date)
      if (sortedList.equals(cards)) {
        print("you won!\n")
        true
      } else {
        print("you lost\n")
        false
      }

    }

  def getCards: List[Card] = cards
  def getPlayers: List[Player] = players
  def getDeck: List[Card] = deck

  }
