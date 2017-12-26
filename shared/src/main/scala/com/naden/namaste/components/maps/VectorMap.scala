package com.naden.namaste.components.maps

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class VectorMap(fixme: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}