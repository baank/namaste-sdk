package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.components._
import com.naden.sdk.models.Component

case class ProgressStatsWidget(title: String,
            subtitle: String,
            percentages: List[Percentage],
            circular: Boolean,
            icon: Option[String],
            color: Color,
            colorAccent: ColorAccent,
            coloredBackground: Boolean,
            relatedValues: List[Value]) extends Component

sealed trait ProgressStyle
object ProgressStyle {
  case object Horizontal extends ProgressStyle
  case object Circular extends ProgressStyle
  case object Half extends ProgressStyle
  case object Speedometer extends ProgressStyle
}


object ProgressStatsWidget {
	implicit val pickler: Pickler[ProgressStatsWidget] = generatePickler[ProgressStatsWidget]
}