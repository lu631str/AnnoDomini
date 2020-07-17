package injection

import com.google.inject.AbstractModule
import controller.ControllerInterface
import model.TableInterface
import model.modelBaseImpl.{Table, TableBuilder}
import net.codingwell.scalaguice.ScalaModule
import model.fileIOComponents._

class AnnoDominiModule extends AbstractModule with ScalaModule {
  override def configure() ={
    val tb = new TableBuilder
    tb.buildTable()
    bind[TableInterface].to[Table]
    bind[ControllerInterface].to[controller.controllerBase.Controller]
    bind[TableInterface].toInstance(tb.getTable)

    bind[FileIOInterface].to[fileIOXmlImpl.FileIO]
  }
}
