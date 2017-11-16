package com.naden.namaste.ui.models

object Color extends Enumeration {
  type Color = Value
  val DEFAULT = Value("default")
  val BLUE = Value("blue")
  val LIGHT_BLUE = Value("info")
  val RED = Value("danger")
  val ORANGE = Value("orange")
  val TEAL = Value("teal")
  val PINK = Value("pink")
  val INDIGO = Value("indigo")
  val VERMILLION = Value("warning")
  val VIOLET = Value("violet")
  val PURPLE = Value("purple")
  val GREEN = Value("success")
  val LIME_GREEN = Value("green")
  val BROWN = Value("brown")
  val GREY = Value("grey")
  val SLATE = Value("slate")
}

object ColorAccent extends Enumeration {
  type ColorAccent = Value
  val DEFAULT = Value("")
  val EIGHT_HUNDRED = Value("800")
  val SEVEN_HUNDRED = Value("700")
  val SIX_HUNDRED = Value("600")
  val FIVE_HUNDRED = Value("500")
  val FOUR_HUNDRED = Value("400")
  val THREE_HUNDRED = Value("300")
}