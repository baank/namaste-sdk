package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class TextFieldElement(name: String,
            label: String,
            idealLength: Option[(Int, Int)] = None,
            maxLength: Option[Int] = None,
            inputFormat: Option[String] = None,
            placeholder: String,
            value: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}