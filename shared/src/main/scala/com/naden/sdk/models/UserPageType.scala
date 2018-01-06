package com.naden.sdk.models

import com.naden.sdk.plugin.Parameter
import com.naden.sdk.plugin.services.{PageType, PanelType}

case class UserPageType(
    createdBy: User,
    title: String,
    description: String,
    listLayout: Layout[PanelSlot],
    detailLayout: Layout[PanelSlot],
    override val instanceParameters: List[Parameter[_]],
    override val globalParameters: List[Parameter[_]],
    override val linkedPanelTypes: Set[PanelType] = Set.empty)
    extends PageType {

  def listLayout(parameterValues: Map[Parameter[_], _]) = listLayout

  def detailLayout(parameterValues: Map[Parameter[_], _]) = detailLayout

  def onStartup(): Unit = {}

  def onShutdown(): Unit = {}
}