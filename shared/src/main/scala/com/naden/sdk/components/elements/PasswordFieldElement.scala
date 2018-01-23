package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class PasswordFieldElement(name: String) extends Component


object PasswordFieldElement {
	implicit val pickler: Pickler[PasswordFieldElement] = generatePickler[PasswordFieldElement]
}