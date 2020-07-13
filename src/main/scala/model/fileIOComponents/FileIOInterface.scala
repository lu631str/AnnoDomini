package model.fileIOComponents
import model.TableInterface


trait FileIOInterface {

  def load: TableInterface
  def save(table: TableInterface)

}
