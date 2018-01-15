package com.naden.sdk.components.elements

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class PasswordFieldElement(name: String) extends Component
