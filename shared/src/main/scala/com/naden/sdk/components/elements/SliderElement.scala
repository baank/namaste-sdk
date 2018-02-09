package com.naden.sdk.components.elements

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec
import enumeratum._

@JsonCodec
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

sealed trait SliderStyle extends EnumEntry
case object SliderStyle extends Enum[SliderStyle] with CirceEnum[SliderStyle] {
  case object Single extends SliderStyle
  case object Double extends SliderStyle
  val values = findValues
}