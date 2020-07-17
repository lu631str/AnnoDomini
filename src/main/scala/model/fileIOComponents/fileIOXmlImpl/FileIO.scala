
package model.fileIOComponents.fileIOXmlImpl

import model.TableInterface
import model.fileIOComponents.FileIOInterface
import model.modelBaseImpl.TableBuilder
import scala.xml.PrettyPrinter


class FileIO extends FileIOInterface {
  override def save(table: TableInterface): Unit = saveString(table)
  override def load: TableInterface = null

  def saveString(table: TableInterface) = {
    import java.io._
    val pw = new PrintWriter(new File("table.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(tableToXml(table))
    pw.write(xml)
    pw.close()
  }

  def tableToXml(table: TableInterface) = {
    <table>
      <cards>{table.getCards}</cards>
      <players>{table.getPlayers}</players>
      <deck>{table.getDeck}</deck>
    </table>
  }

  def tableFromXml(): TableInterface = {

  }
}

object FileIO {

}

