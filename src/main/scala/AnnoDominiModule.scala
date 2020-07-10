import com.google.inject.AbstractModule
import com.google.inject.name.Names
import controller.ControllerInterface
import model.TableInterface
import net.codingwell.scalaguice.ScalaModule
import model.modelBaseImpl.{Table, TableBuilder}


class AnnoDominiModule extends AbstractModule with ScalaModule {
  override def configure() ={
    val tb = new TableBuilder
    tb.buildTable()
    bind[TableInterface].to[Table]
    bind[ControllerInterface].to[controller.controllerBase.Controller]
    bind[TableInterface].toInstance(tb.getTable)
  }
}
