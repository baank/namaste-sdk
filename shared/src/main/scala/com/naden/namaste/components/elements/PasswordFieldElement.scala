package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class PasswordFieldElement(name: String) extends Component {

	@dom def render() = {
		<input name="{name}" type="password" class="form-control" />
	}
}