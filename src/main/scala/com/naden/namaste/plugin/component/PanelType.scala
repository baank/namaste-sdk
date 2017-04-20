package com.naden.namaste.plugin.component

import com.naden.namaste.models.Property

trait PanelType extends BaseComponent {

  // Render
  def render(properyValues: Map[Property[Any], Any]): String

  // Injected into page
  def scripts(): Option[Seq[String]]

  def stylesheets(): Option[Seq[String]]

}
