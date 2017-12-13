package com.naden.namaste.models

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.{PageType, PanelType}

case class UserPageType(
    createdBy: User,
    title: String,
    description: String,
    listLayout: Layout[PanelSlot],
    detailLayout: Layout[PanelSlot],
    override val linkedPanelTypes: Set[PanelType] = Set.empty,
    parameters: Seq[Parameter[_]])
    extends PageType {

  // TODO
  def instanceParameters = Seq.empty
  def globalParameters = Seq.empty
  def onStartup(): Unit = {}
  def onShutdown(): Unit = {}
}
