package controllers.admin

import play.api.Play
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, Controller, ControllerComponents}
import javax.inject.{Inject, Singleton}

import play.api.routing.Router

import scala.collection.mutable.ListBuffer

@Singleton
class RoutesController @Inject() (router: Router, components: ControllerComponents) extends AbstractController(components){

  def index = Action {
    var jsonRoutes = ListBuffer[Map[String,String]]()

    router.documentation.foreach(route => {
      jsonRoutes += Map("method" -> route._1, "path" -> route._2)
    })

    Ok(Json.prettyPrint(Json.toJson(jsonRoutes)))
  }
}