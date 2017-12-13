package com.naden.namaste.components.elements

import com.naden.namaste.components.Component

case class TextFieldElement(name: String,
            label: String,
            idealLength: Option[(Int, Int)] = None,
            maxLength: Option[Int] = None,
            inputFormat: Option[String] = None,
            placeholder: String,
            value: String) extends Component