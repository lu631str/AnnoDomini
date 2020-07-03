package model

import model.TableInterface

trait Builder{
  def reset()  // suposed to set the
  def buildCards()
  def buildPlayers()
  def buildDeck()
  def buildTable()
  def getTable():TableInterface

}
