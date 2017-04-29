package com.naden.namaste.plugin.component

import com.naden.namaste.plugin.rendering.VelocityRenderer

trait PanelType extends Component {

  // Render
  def render(parameterValues: Map[String, _]): String = {
    VelocityRenderer.VM(getClass().getName + ".vm", parameterValues)
  }

  // Injected into page
  def scripts(): Seq[String]
  def stylesheets(): Seq[String]

  // Whether the page is editable or not
  def userEditable(): Boolean

}
