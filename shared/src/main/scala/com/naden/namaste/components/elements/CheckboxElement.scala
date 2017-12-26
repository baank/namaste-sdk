package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class CheckboxElement(name: String,
            label: String,
            checked: Boolean = false) extends Component {

	@dom def render() = {
		<label class="checkbox-inline checkbox-right">
		<input name="{name}" type="checkbox" class="styled" checked="checked" />
		{ label }
		</label>
	}
}
