package com.naden.namaste.components.widgets

import com.naden.namaste.components.{Component, Value}
import com.thoughtworks.binding.dom

case class PieChartWidget(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value]) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}