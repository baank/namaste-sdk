package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import services.Counter

@Singleton
class CountController @Inject() (counter: Counter, components: ControllerComponents) extends AbstractController(components) {

  def count = Action { Ok(counter.nextCount().toString) }

}
