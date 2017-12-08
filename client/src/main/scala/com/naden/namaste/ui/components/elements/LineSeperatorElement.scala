package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object LineSeperatorElement {

  @dom
  def apply(): Binding[Div] = {
    <div></div>
  }
}