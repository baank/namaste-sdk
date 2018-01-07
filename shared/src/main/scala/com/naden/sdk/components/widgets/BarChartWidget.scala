package com.naden.sdk.components.widgets

import com.naden.sdk.components.Component
import boopickle.Default._

object BarChartWidget {
	implicit val pickler = compositePickler[BarChartWidget]
}
case class BarChartWidget(fixme: String) extends Component
