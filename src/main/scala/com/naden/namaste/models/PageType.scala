package com.naden.namaste.models

import scala.collection.SortedMap

case class PageType(var name: String, createdBy: Option[User]) extends Object(createdBy) {

  // Column widths
  var listColumnWidths: SortedMap[Int, Seq[Int]] = SortedMap()
  var detailColumnWidths: SortedMap[Int, Seq[Int]] = SortedMap()

  // Grid of panels organised by (row, column, position)
  var listPanels: SortedMap[(Int, Int), Seq[Panel]] = SortedMap()
  var detailPanels: SortedMap[(Int, Int), Seq[Panel]] = SortedMap()

}