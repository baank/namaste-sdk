package controllers.admin

import javax.inject.{Inject, Singleton}

import play.api.Configuration
import play.api.libs.json._
import play.api.mvc._

@Singleton
class AboutController @Inject() (conf: Configuration, components: ControllerComponents) extends AbstractController(components) {

  def index = Action {
    val map = Map(
      "name" -> conf.get[String]("application.name"),
      "version" -> conf.get[String]("application.version"),
      "branch" -> conf.get[String]("application.branch"),
      "environment" -> conf.get[String]("application.environment"),
      "port" -> conf.get[String]("http.port"),
      "description" -> conf.get[String]("application.description"),
      "organization" -> conf.get[String]("application.organization"),
      "maintainer" -> conf.get[String]("application.maintainer"),
      "vendor" -> conf.get[String]("application.vendor"),
      "license" -> conf.get[String]("application.license"),
      "url" -> conf.get[String]("application.url"))
    Ok(Json.prettyPrint(Json.toJson(map)))
  }
}
