package controllers.admin

import java.io.File
import javax.inject.{Inject, Singleton}

import play.api._
import play.api.mvc._

import scala.io.Source


@Singleton
class ConfigController @Inject() (env: Environment, components: ControllerComponents) extends AbstractController(components){

  def index = Action {
    val confPath = env.rootPath + "/conf/application.conf"
    Ok(Source.fromFile(new File(confPath)).mkString)
  }
}

