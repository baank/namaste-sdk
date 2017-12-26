package com.naden.namaste.components.panels

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class TimerPanel(fixme: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}