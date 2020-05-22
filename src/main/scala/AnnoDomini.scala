import model.{Card, Player}

object AnnoDomini {
    def main(args: Array[String]): Unit = {
      println("Wilkommen bei AnnoDomini!!!")
      val card1 = Card("Mauerfall", 1989)
      val card2 = Card("Anfang zweiter Weltkrieg", 1939)

      val player1 = Player("Alfred", List(card1, card2))
      println("Hello, " + player1.name +  "\nyour cards:" + player1.cards)




    }

}
