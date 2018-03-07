package com.harana.sdk.components.elements

import com.harana.sdk.components.{Color, ColorAccent}
import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TagElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default) extends Component
