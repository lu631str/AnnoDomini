package model.modelBaseImpl

import model.TableInterface

case class Table(cards:List[Card], players:List[Player], deck:List[Card]) extends TableInterface {
  //def apply(cards: List[Card], value: List[Player]): Table = ???

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

  }
