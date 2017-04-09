package models

import scala.collection.mutable

object PanelType extends Enumeration {
  val Related, RecentlyUpdated, MostPopular, GitObject, Photo, Video, Form, Entity, List, User, Wiki, Document, Calendar = Value
}

case class Panel(var name: String, createdBy: Option[User]) extends Object(createdBy: Option[User]) {

  val options = mutable.Map[String, AnyRef]()

}
