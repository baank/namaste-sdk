package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.models.Component

case class AreaChartWidget(fixme: String) extends Component


object AreaChartWidget {
	implicit val pickler: Pickler[AreaChartWidget] = generatePickler[AreaChartWidget]
}