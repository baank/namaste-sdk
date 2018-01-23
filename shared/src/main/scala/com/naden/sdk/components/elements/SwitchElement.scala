package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class SwitchElement(name: String,
            label: String,
            checked: Boolean) extends Component


object SwitchElement {
	implicit val pickler: Pickler[SwitchElement] = generatePickler[SwitchElement]
}