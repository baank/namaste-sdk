package com.naden.namaste.components

object Color extends Enumeration {
  type Color = Value
  val Default = Value
  val Blue = Value
  val LighBlue = Value
  val Red = Value
  val Orange = Value
  val Teal = Value
  val Pink = Value
  val Indigo = Value
  val Vermillion = Value
  val Violet = Value
  val Purple = Value
  val Green = Value
  val LimeGreen = Value
  val Brown = Value
  val Grey = Value
  val Slate = Value
}

object ColorAccent extends Enumeration {
  type ColorAccent = Value
  val Default = Value
  val EightHundred = Value
  val SevenHundred = Value
  val SixHundred = Value
  val FiveHundred = Value
  val FourHundred = Value
  val ThreeHundred = Value
}

object IconPosition extends Enumeration {
  type IconPosition = Value
  val Left = Value
  val Right = Value
}

object IconSize extends Enumeration {
  type IconSize = Value
  val Default = Value
  val ExtraLarge = Value
  val Large = Value
  val Small = Value
  val Mini = Value
}

case class Percentage(percentage: Double, name: String)

case class Value(value: Double, name: String)