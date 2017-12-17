package com.naden.namaste.models

import com.naden.namaste.components.Component
import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.Border.Border
import com.naden.namaste.plugin.services.BorderSize.BorderSize
import com.naden.namaste.plugin.services.Colour.Colour
import com.naden.namaste.plugin.services.PanelType

case class UserPanelType(
    createdBy: User,
    title: String,
    description: String,
    layout: Layout[Component],
    override val instanceParameters: List[Parameter[_]],
    override val globalParameters: List[Parameter[_]],
    override val scripts: Seq[String],
    override val stylesheets: Seq[String],
    override val userEditable: Boolean,
    override val showRefresh: Boolean,
    override val panelColour: Colour,
    override val borders: Set[(Border, BorderSize, Colour)])
    extends PanelType {

  override def layout(parameterValues: Map[Parameter[_], _]) = layout

  override def onStartup(): Unit = {}

  override def onShutdown(): Unit = {}
}
