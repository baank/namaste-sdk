package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class LineSeperatorElement() extends Component


object LineSeperatorElement {
	implicit val pickler: Pickler[LineSeperatorElement] = generatePickler[LineSeperatorElement]
}