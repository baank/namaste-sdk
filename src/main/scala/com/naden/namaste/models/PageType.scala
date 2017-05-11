package com.naden.namaste.models

case class PageType(
    name: String,
    description: String,
    createdBy: User,
    listColumnWidths: Map[Int, Seq[Int]] = Map.empty,
    detailColumnWidths: Map[Int, Seq[Int]] = Map.empty,
    listPanels: Map[(Int, Int), Seq[PanelSlot]] = Map.empty,
    detailPanels: Map[(Int, Int), Seq[PanelSlot]] = Map.empty,
    linkedPanelTypes: Set[PanelType] = Set.empty)
    extends Object(createdBy)
