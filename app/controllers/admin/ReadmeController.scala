package controllers.admin

import java.io.File
import javax.inject.Inject
import javax.inject.{Inject, Singleton}

import org.pegdown.PegDownProcessor
import play.api.{Application, Play}
import play.api.mvc._

import scala.io.Source

@Singleton
class ReadmeController @Inject() (app: Application, components: ControllerComponents) extends AbstractController(components){
  def index = Action {
    val readme = Source.fromFile(new File(app.path + "/README.md")).mkString
    Ok(new PegDownProcessor().markdownToHtml(readme)).as("text/html")
  }
}