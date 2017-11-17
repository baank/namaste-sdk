package com.naden.namaste.ui.models.widgets

import com.naden.namaste.ui.models.Color.Color
import com.naden.namaste.ui.models.widgets.widgets.{Percentage, Value}

case class Progress(title: String,
                    subtitle: String,
                    percentages: List[Percentage],
                    circular: Boolean,
                    icon: Option[String],
                    color: Color,
                    coloredBackground: Boolean,
                    relatedValues: List[Value])

object ProgressStyle extends Enumeration {
  type GaugeStyle = Value
  val HORIZONTAL = Value
  val CIRCULAR = Value
  val HALF = Value
  val SPEEDOMETER = Value
}