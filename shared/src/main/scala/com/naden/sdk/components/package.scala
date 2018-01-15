package com.naden.sdk.components

import io.circe.generic.JsonCodec

@JsonCodec
sealed trait Border
object Border {
  case object Default extends Border
  case object All extends Border
  case object Left extends Border
  case object Right extends Border
  case object Top extends Border
  case object Bottom extends Border
}

@JsonCodec
sealed trait BorderSize
object BorderSize {
  case object Default extends BorderSize
  case object Basic extends BorderSize
  case object Large extends BorderSize
  case object ExtraLarge extends BorderSize
}

@JsonCodec
sealed trait Color
object Color {
  case object Default extends Color
  case object Blue extends Color
  case object LighBlue extends Color
  case object Red extends Color
  case object Orange extends Color
  case object Teal extends Color
  case object Pink extends Color
  case object Indigo extends Color
  case object Vermillion extends Color
  case object Violet extends Color
  case object Purple extends Color
  case object Green extends Color
  case object LimeGreen extends Color
  case object Brown extends Color
  case object Grey extends Color
  case object Slate extends Color
}

@JsonCodec
sealed trait ColorAccent
object ColorAccent {
  case object Default extends ColorAccent
  case object EightHundred extends ColorAccent
  case object SevenHundred extends ColorAccent
  case object SixHundred extends ColorAccent
  case object FiveHundred extends ColorAccent
  case object FourHundred extends ColorAccent
  case object ThreeHundred extends ColorAccent
}

@JsonCodec
sealed trait IconPosition
object IconPosition {
  case object Left extends IconPosition
  case object Right extends IconPosition
}

@JsonCodec
sealed trait IconSize
object IconSize {
  case object Default extends IconSize
  case object ExtraLarge extends IconSize
  case object Large extends IconSize
  case object Small extends IconSize
  case object Mini extends IconSize
}

@JsonCodec
case class Percentage(percentage: Double, name: String)

@JsonCodec
case class Value(value: Double, name: String)