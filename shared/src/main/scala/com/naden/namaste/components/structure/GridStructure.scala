package com.naden.namaste.components.structure

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class GridStructure(fixme: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}