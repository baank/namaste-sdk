import com.google.inject.AbstractModule
import services.atlas.{AtlasEntityService, AtlasUserService}
import services.{EntityService, UserService}
import services.plugin.{OSGIService, PluginService}

class Module extends AbstractModule {

  override def configure() = {

    bind(classOf[PluginService]).to(classOf[OSGIService]).asEagerSingleton()


    bind(classOf[EntityService]).to(classOf[AtlasEntityService])
    bind(classOf[UserService]).to(classOf[AtlasUserService])

  }
}
