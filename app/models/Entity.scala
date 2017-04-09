package models

import scala.collection.mutable

case class Entity(var name: String, entityType: EntityType, createdBy: Option[User]) extends Object(createdBy) {

  // Panel Values
  var panelValues = mutable.Map[Panel, Map[String, AnyRef]]()

}