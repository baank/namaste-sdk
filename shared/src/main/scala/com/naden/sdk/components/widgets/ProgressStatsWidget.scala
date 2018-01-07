package com.naden.sdk.components.widgets

import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.ColorAccent.ColorAccent
import com.naden.sdk.components.{Component, Percentage, Value}
import boopickle.Default._

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
