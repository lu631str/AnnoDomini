import model.{Player, _}
import controller.Controller

import scala.util.Random

val p1 = Player("Player1", List(Card("1", 1), Card("4", 4)))
p1.showHand
p1.addCardAt(1, Card("3", 3)).showHand
p1.addCardAt(0, Card("3", 3)).showHand

val table = Table(List(Card("7", 7)), List(p1), Nil)
table.showCards

val c = new Controller(table)
c.tableToString
"".isEmpty


