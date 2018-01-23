package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class CheckboxElement(name: String,
            label: String,
            checked: Boolean = false) extends Component


object CheckboxElement {
	implicit val pickler: Pickler[CheckboxElement] = generatePickler[CheckboxElement]
}