package com.naden.namaste.models

import scala.collection.mutable.{Set => MutableSet, SortedMap => MutableMap}

class PageType(name: String, description: String, createdBy: Option[User])
    extends Object(createdBy) {

  // Column widths
  val listColumnWidths: MutableMap[Int, Seq[Int]] = MutableMap.empty
  val detailColumnWidths: MutableMap[Int, Seq[Int]] = MutableMap.empty

  // Grid of panels organised by (row, column, position)
  val listPanels: MutableMap[(Int, Int), Seq[PanelType]] = MutableMap.empty
  val detailPanels: MutableMap[(Int, Int), Seq[PanelType]] = MutableMap.empty

  // Panel types that are linked to this page type
  val linkedPanelTypes: MutableSet[PanelType] = MutableSet.empty
}
