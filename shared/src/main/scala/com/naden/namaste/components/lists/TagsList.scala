package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class TagsList(fixme: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}