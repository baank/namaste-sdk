package models

import scala.collection.mutable

case class EntityType(var name: String, createdBy: Option[User]) extends Object(createdBy) {

  // Number of rows
  var rows = 1

  // Number of columns
  var cols = 1

  // Grid of panels organised by (row, column)
  var panels = mutable.Map[(Int, Int), Panel]()

}
