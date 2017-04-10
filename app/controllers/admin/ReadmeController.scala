package controllers.admin

import java.io.File
import javax.inject.{Inject, Singleton}

import com.vladsch.flexmark.html.HtmlRenderer
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet
import play.api.Environment
import play.api.mvc._

import scala.io.Source

@Singleton
class ReadmeController @Inject() (env: Environment, components: ControllerComponents) extends AbstractController(components){

  val parser = Parser.builder(new MutableDataSet()).build
  val renderer = HtmlRenderer.builder(new MutableDataSet()).build

  def index = Action {
    val readme = Source.fromFile(new File(env.rootPath + "/README.md")).mkString
    val html = renderer.render(parser.parse(readme))
    Ok(html).as("text/html")
  }
}