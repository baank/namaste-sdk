package com.naden.sdk.plugin.services

import com.naden.sdk.components.{Border, BorderSize, Color, Component}
import com.naden.sdk.models.Layout
import com.naden.sdk.plugin.{Parameter, Service}

trait PanelType extends Service {

  def scripts: List[String] = List.empty
  def stylesheets: List[String] = List.empty
  def userEditable: Boolean = true

  def panelColour: Color = Color.Default
  def borders: Set[(Border, BorderSize, Color)] = Set.empty[(Border, BorderSize, Color)]

  def layout(parameterValues: List[(Parameter, String)]): Layout[Component]
  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean
}