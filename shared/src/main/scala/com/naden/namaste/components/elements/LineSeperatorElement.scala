package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class LineSeperatorElement() extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}