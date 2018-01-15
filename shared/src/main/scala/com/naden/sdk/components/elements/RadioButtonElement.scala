package com.naden.sdk.components.elements

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component
