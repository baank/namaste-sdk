package com.naden.namaste.ui.models.stats

import com.naden.namaste.ui.models.Color.Color

case class Progress(title: String,
                    subtitle: String,
                    firstPercentage: Option[StatsPercentage],
                    secondPercentage: Option[StatsPercentage],
                    thirdPercentage: Option[StatsPercentage],
                    firstRelatedValue: Option[StatsValue],
                    secondRelatedValue: Option[StatsValue],
                    thirdRelatedValue: Option[StatsValue],
                    circular: Boolean,
                    icon: Option[String],
                    color: Color,
                    coloredBackground: Boolean)