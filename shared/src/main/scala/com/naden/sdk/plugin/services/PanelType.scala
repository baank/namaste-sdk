package com.naden.sdk.plugin.services

import com.naden.sdk.components.Border.Border
import com.naden.sdk.components.BorderSize.BorderSize
import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.{Color, Component}
import com.naden.sdk.models.Layout
import com.naden.sdk.plugin.{Parameter, Service}

trait PanelType extends Service {

  def scripts: Seq[String] = Seq.empty
  def stylesheets: Seq[String] = Seq.empty
  def userEditable: Boolean = true

  def panelColour: Color = Color.Default
  def borders: Set[(Border, BorderSize, Color)] = Set.empty[(Border, BorderSize, Color)]

  def layout(parameterValues: Map[Parameter[_], _]): Layout[Component]
  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean
}