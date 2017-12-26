package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class SwitchElement(name: String,
            label: String,
            checked: Boolean) extends Component {

	@dom def render() = {
		<div class="checkbox checkbox-switchery">
			<label>
				<input name="{ name }" type="checkbox" class="switchery" checked="{ checked }" />
				{ label }
			</label>
		</div>
	}
}