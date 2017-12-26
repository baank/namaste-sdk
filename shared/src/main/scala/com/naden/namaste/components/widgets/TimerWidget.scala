package com.naden.namaste.components.widgets

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class TimerWidget(fixme: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}