package controllers.admin

import java.io.File

import play.api._
import play.api.mvc._

import scala.io.Source
import javax.inject.{Inject, Singleton}


@Singleton
class ConfigController @Inject() (app: Application, components: ControllerComponents) extends AbstractController(components){

  def index = Action {
    val confPath = app.path + "/conf/application.conf"
    Ok(Source.fromFile(new File(confPath)).mkString)
  }
}

