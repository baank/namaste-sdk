package com.naden.namaste.plugin.component

import com.naden.namaste.plugin.rendering.VelocityRenderer

trait PanelType extends Component {

  object Colours extends Enumeration { val Red, Orange, Blue, Cyan, Green = Value }

  // Render
  def render(parameterValues: Map[String, _]): String = {
    VelocityRenderer.VM(getClass().getName + ".vm", parameterValues)
  }

  // Injected into page
  val scripts: Seq[String]
  val stylesheets: Seq[String]

  // Whether the page is editable or not
  val userEditable: Boolean
}
