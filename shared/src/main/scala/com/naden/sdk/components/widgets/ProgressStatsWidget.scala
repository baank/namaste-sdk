package com.naden.sdk.components.widgets

import com.naden.sdk.components._
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec
import enumeratum._

@JsonCodec
case class ProgressStatsWidget(title: String,
            subtitle: String,
            percentages: List[Percentage],
            circular: Boolean,
            icon: Option[String],
            color: Color,
            colorAccent: ColorAccent,
            coloredBackground: Boolean,
            relatedValues: List[Value]) extends Component

sealed trait ProgressStyle extends EnumEntry
case object ProgressStyle extends Enum[ProgressStyle] with CirceEnum[ProgressStyle] {
  case object Horizontal extends ProgressStyle
  case object Circular extends ProgressStyle
  case object Half extends ProgressStyle
  case object Speedometer extends ProgressStyle
  val values = findValues
}