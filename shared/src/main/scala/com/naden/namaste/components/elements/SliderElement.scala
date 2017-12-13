package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.naden.namaste.components.elements.SliderStyle.SliderStyle

case class SliderElement[T](name: String,
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
               decorateBoth: Boolean = false) extends Component

object SliderStyle extends Enumeration {
  type SliderStyle = Value
  val Single = Value
  val Double = Value
}

