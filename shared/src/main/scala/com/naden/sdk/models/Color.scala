package com.naden.sdk.models

import io.circe.generic.JsonCodec
import enumeratum._

sealed trait Color extends EnumEntry
case object Color extends Enum[Color] with CirceEnum[Color] {
	case object Transparent extends Color
	case class RGBA(red: Int, green: Int, blue: Int, alpha: Double) extends Color
	case class RGB(red: Int, green: Int, blue: Int) extends Color
	case class HSLA(hue: Int, saturation: Double, lightness: Double, alpha: Double) extends Color
	case class HSL(hue: Int, saturation: Double, lightness: Double) extends Color
	val values = findValues
}
