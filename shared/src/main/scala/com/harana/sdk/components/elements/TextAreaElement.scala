package com.harana.sdk.components.elements

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component
