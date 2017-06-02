package com.naden.namaste.plugin

import com.naden.namaste.models.Parameter
import com.naden.namaste.plugin.Border.Border
import com.naden.namaste.plugin.BorderSize.BorderSize
import com.naden.namaste.plugin.Colour.Colour
import com.naden.namaste.plugin.FontSize.FontSize
import com.naden.namaste.plugin.util.Localized

trait PanelType extends Localized {

  def scripts: Seq[String] = Seq.empty[String]
  def stylesheets: Seq[String] = Seq.empty[String]
  def userEditable: Boolean = true

  // Refresh
  def showRefresh: Boolean = false
  def refresh(): Unit = ()

  // Appearance
  def titleSize: FontSize
  def panelColour: Colour = Colour.Default
  def borders: Set[(Border, BorderSize, Colour)] = Set.empty[(Border, BorderSize, Colour)]

  // Parameters
  def parameters: Seq[Parameter[_]]
}

object Border extends Enumeration {
  type Border = Value
  val Default, All, Left, Right, Top, Bottom = Value
}

object BorderSize extends Enumeration {
  type BorderSize = Value
  val Default, Basic, Large, ExtraLarge = Value
}

object Colour extends Enumeration {
  type Colour = Value
  val Default, Red, Orange, Blue, Cyan, Green, White, None = Value
}

object FontSize extends Enumeration {
  type FontSize = Value
  val Default, H1, H2, H3, H4, H5, H6 = Value
}
