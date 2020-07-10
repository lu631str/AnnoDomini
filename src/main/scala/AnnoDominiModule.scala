import com.google.inject.AbstractModule
import com.google.inject.name.Names
import controller.ControllerInterface
import model.TableInterface
import net.codingwell.scalaguice.ScalaModule
import model.modelBaseImpl.{Table}


class AnnoDominiModule extends AbstractModule with ScalaModule {
  override def configure() ={
    bind[TableInterface].to[Table]
    bind[ControllerInterface].to[controller.controllerBase.Controller]
  }
}
