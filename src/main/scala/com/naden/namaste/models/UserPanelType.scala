package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.parameters.Parameter
import com.naden.namaste.plugin.services.Border.Border
import com.naden.namaste.plugin.services.BorderSize.BorderSize
import com.naden.namaste.plugin.services.Colour.Colour
import com.naden.namaste.plugin.services.FontSize.FontSize
import com.naden.namaste.plugin.services.PanelType

case class UserPanelType(names: Map[Locale, String],
                         descriptions: Map[Locale, String],
                         createdBy: User,
                         override val scripts: Seq[String],
                         override val stylesheets: Seq[String],
                         override val userEditable: Boolean,
                         override val showRefresh: Boolean,
                         override val titleSize: FontSize,
                         override val panelColour: Colour,
                         override val borders: Set[(Border, BorderSize, Colour)],
                         val parameters: Seq[Parameter[_]])
    extends PanelType {

  def name(implicit locale: Locale): String = names.getOrElse(locale, "")
  def description(implicit locale: Locale): String =
    descriptions.getOrElse(locale, "")

  // TODO
  override def instanceParameters = Seq.empty
  override def globalParameters = Seq.empty

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}
}
