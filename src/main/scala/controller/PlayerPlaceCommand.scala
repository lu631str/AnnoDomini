package controller

import controller.controllerBase.Controller
import util.Command
import model.modelBaseImpl.{Card, Player, Table}

class PlayerPlaceCommand(idxd:Int, idxs:Int, controller: Controller) extends Command{
  var undoList1 = List[Card]()
  var undoList2 = List[Card]()

  override def doStep: Unit = {
    var tempList =  controller.table.returnCards
    var templist2 = controller.table.returnHand
    undoList1 = tempList
    undoList2 = templist2
    tempList = controller.table.givecardsacard(idxd, idxs)
    templist2 = controller.table.takeacardfromplayer(idxd)

    controller.table = Table(tempList,List(Player(controller.table.returnName, templist2)), controller.table.returnDeck)




  }

  override def undoStep: Unit = {
    controller.table = Table(undoList1,List(Player(controller.table.returnName, undoList2)), controller.table.returnDeck)
    //controller.table.players.head.hand = undoList2
  }
  override def redoStep: Unit =
    doStep
}
