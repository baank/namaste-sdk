package com.harana.sdk.components.basic

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class Text(value: String) extends Component