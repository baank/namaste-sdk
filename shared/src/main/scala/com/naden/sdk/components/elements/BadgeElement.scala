package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.components.{Color, ColorAccent}
import com.naden.sdk.models.Component

case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component


object BadgeElement {
	implicit val pickler: Pickler[BadgeElement] = generatePickler[BadgeElement]
}