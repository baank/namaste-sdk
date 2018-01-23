package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component


object TextAreaElement {
	implicit val pickler: Pickler[TextAreaElement] = generatePickler[TextAreaElement]
}