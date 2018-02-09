package com.naden.sdk.components

import io.circe.generic.JsonCodec
import enumeratum._

sealed trait Border extends EnumEntry
case object Border extends Enum[Border] with CirceEnum[Border] {
  case object Default extends Border
  case object All extends Border
  case object Left extends Border
  case object Right extends Border
  case object Top extends Border
  case object Bottom extends Border
  val values = findValues
}

import enumeratum._

sealed trait BorderSize extends EnumEntry
case object BorderSize extends Enum[BorderSize] with CirceEnum[BorderSize] {
  case object Default extends BorderSize
  case object Basic extends BorderSize
  case object Large extends BorderSize
  case object ExtraLarge extends BorderSize
  val values = findValues
}

import enumeratum._

sealed trait Color extends EnumEntry
case object Color extends Enum[Color] with CirceEnum[Color] {
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
  val values = findValues
}

import enumeratum._

sealed trait ColorAccent extends EnumEntry
case object ColorAccent extends Enum[ColorAccent] with CirceEnum[ColorAccent] {
  case object Default extends ColorAccent
  case object EightHundred extends ColorAccent
  case object SevenHundred extends ColorAccent
  case object SixHundred extends ColorAccent
  case object FiveHundred extends ColorAccent
  case object FourHundred extends ColorAccent
  case object ThreeHundred extends ColorAccent
  val values = findValues
}

import enumeratum._

sealed trait IconPosition extends EnumEntry
case object IconPosition extends Enum[IconPosition] with CirceEnum[IconPosition] {
  case object Left extends IconPosition
  case object Right extends IconPosition
  val values = findValues
}

import enumeratum._

sealed trait IconSize extends EnumEntry
case object IconSize extends Enum[IconSize] with CirceEnum[IconSize] {
  case object Default extends IconSize
  case object ExtraLarge extends IconSize
  case object Large extends IconSize
  case object Small extends IconSize
  case object Mini extends IconSize
  val values = findValues
}

@JsonCodec
case class Percentage(percentage: Double, name: String)

@JsonCodec
case class Value(value: Double, name: String)