package view.Gui

import controller.{ControllerInterface, GameChange, PlayerPlaceCommand}
import controller.controllerBase.Controller
import javax.swing.border.LineBorder
import model.modelBaseImpl.{Card, Player, Table}

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



  contents = new BorderPanel {

    add(cardPanelPlayer, BorderPanel.Position.Center)
    add(cardPanelCards, BorderPanel.Position.North)
    add(deck, BorderPanel.Position.East)

  }


  def deck = new BoxPanel(Orientation.Horizontal) {
    val button = new Button("Deck")

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
    val button2 = new Button("")
    contents += button2
    button2.font = new Font("Verdana", 5, 10)
    button2.preferredSize = (new Dimension(20, 360))
    button2.maximumSize_=(new Dimension(20, 360))
    button2.minimumSize_=(new Dimension(20, 360))
    for (i <- 0 to controller.getListleghtFromCards - 1) {

      val button2 = new Button(""){
        listenTo(this)

        reactions += {
          case e: ButtonClicked =>
            if(isHandSelected){
              //controller.placeCard(index , i+1)
              var controller2 = controller.returnController
              var command = new PlayerPlaceCommand(index, i+1, controller2)
              controller.doStep(command)
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


      contents += button
      contents += button2

      listenTo(button)
      listenTo(button2)
      background = java.awt.Color.WHITE
      listenTo(controller)

      reactions += {
        case ButtonClicked(`button`) => {
          repaint()

        }
      }

    }

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
    val controller: Controller = new Controller(Table(List(Card("Test1", 1800), Card("Test2", 1800), Card("Test3", 1800)), List(Player("player 1", List(Card("Test4", 1802), Card("Test5", 1802), Card("Test6", 1802)))), List(Card("Test7", 1803), Card("Test8", 1803), Card("Test9", 1803))))
    val gui = new Gui(controller)
    var index = gui.index

    println(controller.tableToString)
    println(controller.table.returnName)


    println("End of main function")
  }
}