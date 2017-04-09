package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}
import services.EntityService

@Singleton
class EntityController @Inject()(entityId: String, entityService: EntityService, components: ControllerComponents, assetsFinder: AssetsFinder) extends AbstractController(components) {

  def index = Action {
    val entity = entityService.get(entityId)

    Ok(views.html.ViewEntity(entity, "Your new application is ready.", assetsFinder))
  }
}
