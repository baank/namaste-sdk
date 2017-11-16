package com.naden.namaste.ui.models.stats

case class PieChart(title: String,
                    subtitle: String,
                    firstValue: Option[StatsValue],
                    secondValue: Option[StatsValue],
                    thirdValue: Option[StatsValue],
                    firstRelatedValue: Option[StatsValue],
                    secondRelatedValue: Option[StatsValue],
                    thirdRelatedValue: Option[StatsValue])

object IconPosition extends Enumeration {
  type IconPosition = Value
  val LEFT = Value
  val RIGHT = Value
}

