package view.Gui


import controller.ControllerInterface

import scala.swing._

import scala.swing.event.Key
import scala.swing.{Action, Menu, MenuBar, MenuItem, TextField}

class GUIMenuBar(controller: ControllerInterface) extends MenuBar {
  def menuBar:MenuBar = {
    val menuBar = new MenuBar {
      contents += new Menu("File") {
        mnemonic = Key.F
        contents += new MenuItem(Action("Quit") { System.exit(0) })
      }
      contents += new Menu("Edit") {
        mnemonic = Key.E
        contents += new MenuItem(Action("Undo") { controller.undo })
        contents += new MenuItem(Action("Redo") { controller.redo })
        contents += new MenuItem(Action("Check") { controller.checkCardOrder })
      }
    }
    menuBar
  }

}