package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.Border.Border
import com.naden.namaste.plugin.BorderSize.BorderSize
import com.naden.namaste.plugin.Colour.Colour
import com.naden.namaste.plugin.FontSize.FontSize
import com.naden.namaste.plugin.PanelType

case class CustomPanelType(names: Map[Locale, String],
                           descriptions: Map[Locale, String],
                           createdBy: User,
                           override val scripts: Seq[String],
                           override val stylesheets: Seq[String],
                           override val userEditable: Boolean,
                           override val showRefresh: Boolean,
                           override val titleSize: FontSize,
                           override val panelColour: Colour,
                           override val borders: Set[(Border, BorderSize, Colour)],
                           override val parameters: Seq[Parameter[_]])
    extends Object(createdBy)
    with PanelType {

  override def name(implicit locale: Locale): String = names.getOrElse(locale, "")
  override def description(implicit locale: Locale): String =
    descriptions.getOrElse(locale, "")
}
