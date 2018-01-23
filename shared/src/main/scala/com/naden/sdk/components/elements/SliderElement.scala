package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

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

sealed trait SliderStyle
object SliderStyle {
  case object Single extends SliderStyle
  case object Double extends SliderStyle
}

object SliderElement {
	implicit val pickler: Pickler[SliderElement] = generatePickler[SliderElement]
}