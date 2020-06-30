package controller

import util.Command
import model.Card


class PlayerPlaceCommand(idxd:Int, idxs:Int, controller: Controller) extends Command{
  var undoList1 = List[Card]()
  var undoList2 = List[Card]()

  override def doStep: Unit = {
    var tempList = controller.table.cards
    var templist2 = controller.table.players.head.hand
    undoList1 = tempList
    undoList2 = templist2
    tempList = tempList :+ controller.table.players.head.hand(idxs)
    templist2 = controller.table.players.head.hand.patch(idxs, Nil, 1)
    controller.table.cards = tempList
    controller.table.players.head.hand = templist2



  }

  override def undoStep: Unit = {
    controller.table.cards = undoList1
    controller.table.players.head.hand = undoList2
  }
  override def redoStep: Unit =
    doStep
}
