package com.naden.namaste.components.widgets

import com.naden.namaste.components.Value
import com.thoughtworks.binding.dom

case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value]) {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}