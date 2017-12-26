package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class PasswordGeneratorElement(name: String,
            label: String,
            checked: Boolean) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}