//package model
/*
import scala.util.Random

case class Deck(deck:List[Card]){

  def draw: (Card, Deck) = (deck.head, Deck(deck.tail))
  def draw(x:Int): (List[Card], List[Card]) = (deck.splitAt(x)._1, deck.splitAt(x)._2)

  def shuffle: Deck = Deck(Random.shuffle(deck))


  /*
  you know I just spend an hour or so trying to come up with a
  clever method, that would transfer a list into an array and then
  randomly swap the cards to shuffle it, then I thought "maybe there
  already is a predefined way of randomizing lists."
  And it turned out there is.
  I spent an hour coding and testing out things just so
  I could scrap all of it and solve the problem in one line... fml
   */
}
*/