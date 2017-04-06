package models

import java.util.{Date, UUID}

import scala.collection.mutable

class Entity(var name: String, entityType: EntityType, createdBy: String) extends AtlasObject(createdBy) {

  // Icon
  var icon = "Default.png"

  // Panel Values
  var panelValues = mutable.Map[Panel, Map[String, AnyRef]]()

}