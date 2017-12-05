package com.naden.namaste.plugin.services

import com.naden.namaste.plugin.Service
import com.naden.namaste.plugin.services.Border.Border
import com.naden.namaste.plugin.services.BorderSize.BorderSize
import com.naden.namaste.plugin.services.Colour.Colour
import com.naden.namaste.plugin.services.FontSize.FontSize

trait PanelType extends Service {

  def scripts: Seq[String] = Seq.empty
  def stylesheets: Seq[String] = Seq.empty
  def userEditable: Boolean = true

  // Refresh
  def showRefresh: Boolean = false
  def refresh(): Unit = ()

  // Appearance
  def titleSize: FontSize = FontSize.Default
  def panelColour: Colour = Colour.Default
  def borders: Set[(Border, BorderSize, Colour)] = Set.empty[(Border, BorderSize, Colour)]

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
