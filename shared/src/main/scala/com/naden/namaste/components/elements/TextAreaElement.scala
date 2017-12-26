package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}