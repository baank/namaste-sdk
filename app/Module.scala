import com.google.inject.AbstractModule
import services.atlas.AtlasUserService
import services.mock.{MockPageService, MockPageTypeService, MockPanelService}
import services.plugin.{OSGIService, PluginService}
import services.{PageService, PageTypeService, PanelService, UserService}

class Module extends AbstractModule {

  override def configure() = {

    bind(classOf[PluginService]).to(classOf[OSGIService]).asEagerSingleton()

    bind(classOf[PageService]).to(classOf[MockPageService])
    bind(classOf[PageTypeService]).to(classOf[MockPageTypeService])
    bind(classOf[PanelService]).to(classOf[MockPanelService])
    bind(classOf[UserService]).to(classOf[AtlasUserService])

  }
}
