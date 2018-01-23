package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component


object RadioButtonElement {
	implicit val pickler: Pickler[RadioButtonElement] = generatePickler[RadioButtonElement]
}