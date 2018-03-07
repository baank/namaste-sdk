package com.harana.sdk.components.elements

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TextFieldElement(name: String,
            label: String,
            idealLength: Option[(Int, Int)] = None,
            maxLength: Option[Int] = None,
            inputFormat: Option[String] = None,
            placeholder: String,
            value: String) extends Component
