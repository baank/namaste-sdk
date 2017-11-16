package com.naden.namaste.ui.models.stats.singlevalue

import com.naden.namaste.ui.models.Color.Color
import com.naden.namaste.ui.models.form.IconPosition.IconPosition

case class Counter(value: String,
                   valueName: String,
                   icon: String,
                   iconPosition: IconPosition,
                   color: Color,
                   coloredBackground: Boolean)

object IconPosition extends Enumeration {
  type IconPosition = Value
  val LEFT = Value
  val RIGHT = Value
}