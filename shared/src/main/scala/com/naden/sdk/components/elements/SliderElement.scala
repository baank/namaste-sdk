package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import com.naden.sdk.components.elements.SliderStyle.SliderStyle

case class SliderElement(name: String,
                          label: String,
                          style: SliderStyle,
                          minimum: Option[Int],
                          maximum: Option[Int],
                          from: Option[Int] = None,
                          to: Option[Int] = None,
                          step: Option[Int] = None,
                          grid: Boolean = false,
                          prefix: String = "",
                          postfix: String = "",
                          maximumPostfix: String = "",
                          values: List[Int] = List.empty,
                          valuesSeperator: String = " - ",
                          prettify: Boolean = false,
                          prettifySeperator: String = "",
                          decorateBoth: Boolean = false) extends Component
                            
case object SliderStyle extends Enumeration {
  type SliderStyle = Value
  val Single = Value
  val Double = Value
}
