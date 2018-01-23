package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.components.{Color, ColorAccent}
import com.naden.sdk.models.Component

case class TagElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default) extends Component


object TagElement {
	implicit val pickler: Pickler[TagElement] = generatePickler[TagElement]
}