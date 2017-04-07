import com.google.inject.AbstractModule
import services.atlas.AtlasUserService
import services.UserService
import services.plugin.{OSGIService, PluginService}

class Module extends AbstractModule {

  override def configure() = {

    bind(classOf[PluginService]).to(classOf[OSGIService]).asEagerSingleton()

    bind(classOf[UserService]).to(classOf[AtlasUserService])

  }
}
