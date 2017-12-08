package com.naden.namaste.ui.components.elements

import com.naden.namaste.ui.components.elements.SliderElement.SliderStyle.SliderStyle
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object SliderElement {

  @dom
  def apply[T](name: String,
               label: String,
               style: SliderStyle,
               minimum: Option[T] = Some(0),
               maximum: Option[T] = Some(100),
               from: Option[T] = None,
               to: Option[T] = None,
               step: Option[T] = None,
               grid: Boolean = false,
               prefix: String = "",
               postfix: String = "",
               maximumPostfix: String = "",
               values: List[Any] = List(),
               valuesSeperator: String = " - ",
               prettify: Boolean = false,
               prettifySeperator: String = "",
               decorateBoth: Boolean = false): Binding[Div] = {
    <div></div>
  }

  object SliderStyle extends Enumeration {
    type SliderStyle = Value
    val SINGLE = Value("")
    val DOUBLE = Value("double")
  }
}

