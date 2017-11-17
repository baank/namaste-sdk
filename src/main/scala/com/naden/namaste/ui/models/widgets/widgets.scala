package com.naden.namaste.ui.models.widgets

package object widgets {

  object IconPosition extends Enumeration {
    type IconPosition = Value
    val LEFT = Value
    val RIGHT = Value
  }

  case class Percentage(percentage: Double, name: String)
  case class Value(value: Double, name: String)
}
