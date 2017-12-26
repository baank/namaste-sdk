package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component {

	@dom def render() = {
		<label>
		<input type="radio" name="{name}" class="styled" checked="{checked}" />
		{ label }
		</label>
	}
}