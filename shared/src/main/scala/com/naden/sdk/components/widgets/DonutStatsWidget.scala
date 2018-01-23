package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.models.Component

case class DonutStatsWidget(fixme: String) extends Component

object DonutStatsWidget {
	implicit val pickler: Pickler[DonutStatsWidget] = generatePickler[DonutStatsWidget]
}