package com.naden.namaste.components.elements

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.ColorAccent.ColorAccent
import com.naden.namaste.components.IconSize.IconSize
import com.naden.namaste.components.{Color, ColorAccent, Component, IconSize}
import com.thoughtworks.binding.dom

case class ButtonElement(name: String,
            label: String,
            size: IconSize = IconSize.Default,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false) extends Component {

	@dom def render() = {
		<button type="button" class="btn btn-primary btn-rounded btn-xlg">
			<i class="icon-mention position-left" />
			Extra large size
		</button>
	}
}