package controller

import controller.controllerBase.Controller
import util.Command
import model.modelBaseImpl.{Card, Player, Table}

class PlayerPlaceCommand(idxd:Int, idxs:Int, controller: Controller) extends Command{
  var undoList1 = List[Card]()
  var undoList2 = List[Card]()

  override def doStep: Unit = {
    var tempList = controller.table.cards
    var templist2 = controller.table.players.head.hand
    undoList1 = tempList
    undoList2 = templist2
    tempList = controller.table.cards.patch(idxd,List(controller.table.players.head.hand(idxs)) , 0)
    templist2 = controller.table.players.head.hand.patch(idxs, Nil, 1)

    controller.table = Table(tempList,List(Player(controller.table.players.head.name, templist2)), controller.table.deck)




  }

  override def undoStep: Unit = {
    controller.table = Table(undoList1,List(Player(controller.table.players.head.name, undoList2)), controller.table.deck)
    controller.table.players.head.hand = undoList2
  }
  override def redoStep: Unit =
    doStep
}
