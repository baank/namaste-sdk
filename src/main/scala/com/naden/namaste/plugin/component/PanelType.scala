package com.naden.namaste.plugin.component

import com.naden.namaste.models.Parameter

trait PanelType extends BaseComponent {

  // Render
  def render(properyValues: Map[Parameter[Any], Any]): String

  // Injected into page
  def scripts(): Option[Seq[String]]

  def stylesheets(): Option[Seq[String]]

}
