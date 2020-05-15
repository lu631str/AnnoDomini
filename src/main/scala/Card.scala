case class Card(text: String, date: Int){
  def look = s"$text"
  def reveal = s"$date"
}