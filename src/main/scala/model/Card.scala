package model

case class Card(text: String, date: Int){
  def look = s"$text"
  def reveal = s"$date"

  override def toString: String =
    text.replace('0', ' ')
}