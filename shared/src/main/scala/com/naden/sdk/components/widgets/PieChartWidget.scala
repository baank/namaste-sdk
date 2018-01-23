package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.components.Value
import com.naden.sdk.models.Component

case class PieChartWidget(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value]) extends Component


object PieChartWidget {
	implicit val pickler: Pickler[PieChartWidget] = generatePickler[PieChartWidget]
}