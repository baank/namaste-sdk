package controllers.admin

import java.io.File
import javax.inject.{Inject, Singleton}

import play.api._
import play.api.mvc._

import scala.io.Source

@Singleton
class LogsController @Inject() (env: Environment, components: ControllerComponents) extends AbstractController(components){

  def index = Action {
    val logPath = env.rootPath + "/logs/application.log"
    Ok(Source.fromFile(new File(logPath)).mkString)
  }
}