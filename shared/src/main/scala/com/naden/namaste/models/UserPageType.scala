package com.naden.namaste.models

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.{PageType, PanelType}

case class UserPageType(
    name: String,
    description: String,
    createdBy: User,
    override val listColumnWidths: Map[Int, Seq[Int]],
    override val detailColumnWidths: Map[Int, Seq[Int]],
    override val listStructure: Map[(Int, Int), Seq[PanelSlot]],
    override val detailStructure: Map[(Int, Int), Seq[PanelSlot]],
    override val linkedPanelTypes: Set[PanelType] = Set.empty,
    parameters: Seq[Parameter[_]])
    extends PageType {

  // TODO
  override def instanceParameters = Seq.empty
  override def globalParameters = Seq.empty

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}
}
