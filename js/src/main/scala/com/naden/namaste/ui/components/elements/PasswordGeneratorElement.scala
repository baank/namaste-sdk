package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object PasswordGeneratorElement {

  @dom
  def apply(name: String,
            label: String,
            checked: Boolean): Binding[Div] = {
    <div></div>
  }
}