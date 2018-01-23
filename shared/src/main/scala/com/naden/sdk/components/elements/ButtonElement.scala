package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.components.{Color, ColorAccent, IconSize}
import com.naden.sdk.models.Component

case class ButtonElement(name: String,
            label: String,
            size: IconSize = IconSize.Default,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false) extends Component


object ButtonElement {
	implicit val pickler: Pickler[ButtonElement] = generatePickler[ButtonElement]
}