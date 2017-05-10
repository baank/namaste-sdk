package com.naden.namaste.models

import scala.collection.mutable.{Set => MutableSet, SortedMap => MutableMap}

case class PageType(
    name: String,
    description: String,
    createdBy: Option[User],
    listColumnWidths: MutableMap[Int, Seq[Int]] = MutableMap.empty,
    detailColumnWidths: MutableMap[Int, Seq[Int]],
    listPanels: MutableMap[(Int, Int), Seq[PanelSlot]] = MutableMap.empty,
    detailPanels: MutableMap[(Int, Int), Seq[PanelSlot]] = MutableMap.empty,
    linkedPanelTypes: MutableSet[PanelType] = MutableSet.empty)
    extends Object(createdBy)
