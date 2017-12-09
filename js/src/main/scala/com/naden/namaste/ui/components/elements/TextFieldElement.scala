package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object TextFieldElement {

  @dom
  def apply(name: String,
            label: String,
            idealLength: Option[(Int, Int)] = None,
            maxLength: Option[Int] = None,
            inputFormat: Option[String] = None,
            placeholder: String,
            value: String): Binding[Div] = {
    <div></div>
  }
}