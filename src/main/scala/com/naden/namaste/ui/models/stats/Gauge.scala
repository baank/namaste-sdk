package com.naden.namaste.ui.models.stats

case class Gauge(title: String,
                 subtitle: String,
                 percentage: Int,
                 firstRelatedValue: Option[StatsValue],
                 secondRelatedValue: Option[StatsValue],
                 thirdRelatedValue: Option[StatsValue])