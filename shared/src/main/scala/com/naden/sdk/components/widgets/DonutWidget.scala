package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.components.Value
import com.naden.sdk.models.Component

case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value]) extends Component


object DonutWidget {
	implicit val pickler: Pickler[DonutWidget] = generatePickler[DonutWidget]
}