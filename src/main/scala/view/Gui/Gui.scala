package view.Gui

import controller.{ControllerInterface, GameChange, PlayerPlaceCommand, end}
import controller.controllerBase.Controller
import javax.swing.border.LineBorder
import model.modelBaseImpl.{Card, CardStack, Player, Table}

import scala.swing.Publisher
import scala.swing._
import scala.swing.event._
import java.awt.Toolkit

class Gui(controller: ControllerInterface) extends MainFrame {
  listenTo(controller)
  title = "Anno Domini"
  size = new Dimension(1600, 770)
  maximumSize = new Dimension(1600, 770)
  minimumSize = new Dimension(1600, 770)

  var index = 0
  var currentButton = ""
  var isHandSelected = false
  var status = controller.setCheckCardOrder







  def statusasstring: String = {
    if (status){
      return "Won"
    }else{
      return "Lost"
    }

  }




  contents = new BorderPanel {

    add(cardPanelPlayer, BorderPanel.Position.Center)
    add(cardPanelCards, BorderPanel.Position.North)
    add(deck, BorderPanel.Position.East)

  }


  def deck = new BoxPanel(Orientation.Horizontal) {
    val button = new Button("Decks")




    button.font = new Font("Verdana", 5, 10)
    button.preferredSize = (new Dimension(200, 360))
    button.maximumSize_=(new Dimension(200, 360))
    button.minimumSize_=(new Dimension(200, 360))
    contents += button
    listenTo(button)
    background = java.awt.Color.WHITE
    listenTo(controller)

    reactions += {
      case ButtonClicked(`button`) => {
        controller.draw
        println(controller.tableToString)
        repaint()

      }

    }

  }


  def cardPanelCards = new BoxPanel(Orientation.Horizontal) {


    for (i <- 0 to controller.getListleghtFromCards - 1) {


      val button2 = new Button("") {
        listenTo(this)

        reactions += {
          case e: ButtonClicked =>

            if (isHandSelected) {
              //controller.placeCard(index , i)
              var controller2 = controller.returnController
              var command = new PlayerPlaceCommand(index, i, controller2)
              status = controller.setCheckCardOrder
              controller.doStep(command)
              status = controller.setCheckCardOrder
              println(currentButton)

            }


        }

      }


      val button = new Button(controller.getCardTextFromCards(i))

      button.font = new Font("Verdana", 5, 10)
      button.preferredSize = (new Dimension(200, 360))
      button.maximumSize_=(new Dimension(200, 360))
      button.minimumSize_=(new Dimension(200, 360))

      button2.font = new Font("Verdana", 5, 10)
      button2.preferredSize = (new Dimension(20, 360))
      button2.maximumSize_=(new Dimension(20, 360))
      button2.minimumSize_=(new Dimension(20, 360))


      contents += button2
      contents += button




      listenTo(button)
      listenTo(button2)
      background = java.awt.Color.WHITE
      listenTo(controller)


      reactions += {
        case ButtonClicked(`button`) => {
          status = controller.setCheckCardOrder
          repaint()

        }
      }

    }

    val button3 = new Button("") {
      listenTo(this)

      reactions += {
        case e: ButtonClicked =>

          if (isHandSelected) {
            //controller.placeCard(index , i)
            var controller2 = controller.returnController
            var command = new PlayerPlaceCommand(index, controller.getListleghtFromCards, controller2)
            status = controller.setCheckCardOrder
            controller.doStep(command)
            status = controller.setCheckCardOrder
            println(currentButton)

          }


      }



    }
    button3.font = new Font("Verdana", 5, 10)
    button3.preferredSize = (new Dimension(20, 360))
    button3.maximumSize_=(new Dimension(20, 360))
    button3.minimumSize_=(new Dimension(20, 360))
    contents += button3
  }








  def cardPanelPlayer = new BoxPanel(Orientation.Horizontal) {


    for (i <- 0 to controller.getListleghtFromPlayer - 1) {


      val button = new Button(controller.getCardTextFromPlayer(i)) {
        listenTo(this)

        reactions += {
          case e: ButtonClicked =>
            isHandSelected = true
            index = i
            background = java.awt.Color.GREEN



            println(i)

        }

      }


      button.font = new Font("Verdana", 5, 10)
      button.preferredSize = (new Dimension(200, 360))
      button.maximumSize_=(new Dimension(200, 360))
      button.minimumSize_=(new Dimension(200, 360))

      contents += button
      listenTo(button)
      background = java.awt.Color.WHITE
      listenTo(controller)


      reactions += {
        case ButtonClicked(`button`) => {
          isHandSelected = true
          status = controller.setCheckCardOrder



          repaint()
        }


      }


    }


  }


  def spielerName = new TextArea() {
    columns = 4

  }


  menuBar = new GUIMenuBar(controller).menuBar
  //contents = Button("test")(controller.setPlayerName("test")

  pack()
  visible = true
  centerOnScreen


  reactions += {
    case event: GameChange => redraw
    case event: end =>{
      status = controller.setCheckCardOrder
      end
    }


  }

  def end:Unit ={
  contents = new BorderPanel {

    add(cardPanelPlayer, BorderPanel.Position.Center)
    add(cardPanelCards, BorderPanel.Position.North)
    add(deck, BorderPanel.Position.East)
    add(endText, (BorderPanel.Position.South))

  }

  }


  def endText = new BoxPanel(Orientation.Horizontal) {


    var cards = controller.returnCards

    var cards2 = List[Int]()

    for (i <- 0 to cards.length -1){

      cards2 = cards2 :+ cards(i).date

    }
    val textfield = new TextField("You:" + statusasstring + " " + cards2.mkString(","))
    listenTo(textfield)








    if(status)
      textfield.background = java.awt.Color.GREEN
    else
      textfield.background = java.awt.Color.RED

    textfield.font = new Font("Verdana", 5, 80)
    textfield.preferredSize = (new Dimension(1600, 180))
    textfield.maximumSize_=(new Dimension(1600, 180))
    textfield.minimumSize_=(new Dimension(1600, 180))

    contents += textfield
    listenTo(textfield)

    listenTo(controller)



  }





  def redraw = {

    contents = new BorderPanel {

      add(cardPanelPlayer, BorderPanel.Position.Center)
      add(cardPanelCards, BorderPanel.Position.North)
      add(deck, BorderPanel.Position.East)

    }


  }


}


object GuiProgramOne {
  def main(args: Array[String]) {
    val controller: Controller = new Controller(Table(List(Card("MauerFall", 1989 )), List(Player("player 1", List(Card("Mord Kennedy",1963), Card("Anfang 1.Weltkrieg", 1914), Card("1. Telefongespräch", 1881)))), CardStack.initialize))
    val gui = new Gui(controller)
    var index = gui.index

    println(controller.tableToString)
    println(controller.table.returnName)


    println("End of main function")
  }
}