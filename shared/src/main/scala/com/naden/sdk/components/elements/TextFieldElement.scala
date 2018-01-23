package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class TextFieldElement(name: String,
            label: String,
            idealLength: Option[(Int, Int)] = None,
            maxLength: Option[Int] = None,
            inputFormat: Option[String] = None,
            placeholder: String,
            value: String) extends Component


object TextFieldElement {
	implicit val pickler: Pickler[TextFieldElement] = generatePickler[TextFieldElement]
}