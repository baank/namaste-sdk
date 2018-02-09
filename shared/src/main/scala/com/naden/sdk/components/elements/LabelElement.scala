package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent}
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec
import enumeratum._

@JsonCodec
case class LabelElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labelStyle: LabelStyle = LabelStyle.Default,
            icon: String = "") extends Component


sealed trait LabelStyle extends EnumEntry
case object LabelStyle extends Enum[LabelStyle] with CirceEnum[LabelStyle] {
  case object Default extends LabelStyle
  case object Rounded extends LabelStyle
  case object Square extends LabelStyle
  case object Block extends LabelStyle
  case object Flat extends LabelStyle
  val values = findValues
}
