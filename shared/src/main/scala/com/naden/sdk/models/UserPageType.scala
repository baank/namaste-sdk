package com.naden.sdk.models

import com.naden.sdk.plugin.Parameter
import com.naden.sdk.plugin.services.{PageType, PanelType}

case class UserPageType(
    createdBy: User,
    title: String,
    description: String,
    listLayout: Layout[PanelSlot],
    detailLayout: Layout[PanelSlot],
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val linkedPanelTypes: Set[PanelType] = Set.empty)
    extends PageType {

  def listLayout(parameterValues: Map[Parameter, _]) = listLayout

  def detailLayout(parameterValues: Map[Parameter, _]) = detailLayout

  def onStartup(): Unit = {}

  def onShutdown(): Unit = {}
}