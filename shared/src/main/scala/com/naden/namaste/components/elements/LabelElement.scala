package com.naden.namaste.components.elements

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.{Color, ColorAccent, Component}
import com.naden.namaste.components.ColorAccent.ColorAccent
import com.naden.namaste.components.elements.LabelStyle.LabelStyle
import com.thoughtworks.binding.dom

case class LabelElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labelStyle: LabelStyle = LabelStyle.Default,
            icon: String = "") extends Component {

  @dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}

object LabelStyle extends Enumeration {
  type LabelStyle = Value
  val Default = Value
  val Rounded = Value
  val Square = Value
  val Block = Value
  val Flat = Value
}