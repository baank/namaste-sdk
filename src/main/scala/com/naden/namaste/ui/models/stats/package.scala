package com.naden.namaste.ui.models

package object stats {

  object IconPosition extends Enumeration {
    type IconPosition = Value
    val LEFT = Value
    val RIGHT = Value
  }

  case class StatsPercentage(percentage: String, percentageName: String)
  case class StatsValue(value: String, valueName: String)
}

