package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class HomeController @Inject() (components: ControllerComponents, assetsFinder: AssetsFinder) extends AbstractController(components) {

  def index = Action {
    Ok(views.html.Index("Your new application is ready.", assetsFinder))
  }
}
