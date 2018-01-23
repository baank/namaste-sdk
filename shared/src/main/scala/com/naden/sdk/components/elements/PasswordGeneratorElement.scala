package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class PasswordGeneratorElement(name: String,
            label: String,
            checked: Boolean) extends Component


object PasswordGeneratorElement {
	implicit val pickler: Pickler[PasswordGeneratorElement] = generatePickler[PasswordGeneratorElement]
}