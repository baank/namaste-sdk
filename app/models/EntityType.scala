package models

import scala.collection.mutable

class EntityType(var name: String, createdBy: String) extends Object(createdBy) {

  // Icon file name
  var icon = "Default.png"

  // Number of rows
  var rows = 1

  // Number of columns
  var cols = 1

  // Grid of panels organised by (row, column)
  val panels = mutable.Map[(Int, Int), Panel]()

}
