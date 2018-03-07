package com.harana.sdk.components.elements

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class PasswordGeneratorElement(name: String,
            label: String,
            checked: Boolean) extends Component
