package controllers.admin

import play.api.{Application}
import play.api.libs.json._
import play.api.mvc._
import javax.inject.{Inject, Singleton}

@Singleton
class AboutController @Inject() (components: ControllerComponents, app: Application) extends AbstractController(components) {

  def index = Action {
    val conf = app.configuration
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
