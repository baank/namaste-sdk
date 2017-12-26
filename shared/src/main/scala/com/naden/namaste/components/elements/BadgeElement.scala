package com.naden.namaste.components.elements

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.{Color, ColorAccent, Component}
import com.naden.namaste.components.ColorAccent.ColorAccent
import com.thoughtworks.binding.dom

case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}