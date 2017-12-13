package com.naden.namaste.models

import java.awt.Component

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.Border.Border
import com.naden.namaste.plugin.services.BorderSize.BorderSize
import com.naden.namaste.plugin.services.Colour.Colour
import com.naden.namaste.plugin.services.FontSize.FontSize
import com.naden.namaste.plugin.services.PanelType

case class UserPanelType(
    createdBy: User,
    title: String,
    description: String,
    override val scripts: Seq[String],
    override val stylesheets: Seq[String],
    override val userEditable: Boolean,
    override val showRefresh: Boolean,
    override val titleSize: FontSize,
    override val panelColour: Colour,
    override val borders: Set[(Border, BorderSize, Colour)],
    override val layout: Layout[Component],
    parameters: Seq[Parameter[_]])
    extends PanelType {

  // TODO
  override def instanceParameters = Seq.empty

  override def globalParameters = Seq.empty

  override def onStartup(): Unit = {}

  override def onShutdown(): Unit = {}
}
