package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.models.Component

case class BarChartWidget(fixme: String) extends Component

object BarChartWidget {
	implicit val pickler: Pickler[BarChartWidget] = generatePickler[BarChartWidget]
}