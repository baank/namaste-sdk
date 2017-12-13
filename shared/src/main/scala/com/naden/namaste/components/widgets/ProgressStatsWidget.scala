package com.naden.namaste.components.widgets

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.ColorAccent.ColorAccent
import com.naden.namaste.components.{Component, Percentage, Value}

case class ProgressStatsWidget(title: String,
            subtitle: String,
            percentages: List[Percentage],
            circular: Boolean,
            icon: Option[String],
            color: Color,
            colorAccent: ColorAccent,
            coloredBackground: Boolean,
            relatedValues: List[Value]) extends Component

object ProgressStyle extends Enumeration {
  type GaugeStyle = Value
  val HORIZONTAL = Value
  val CIRCULAR = Value
  val HALF = Value
  val SPEEDOMETER = Value
}