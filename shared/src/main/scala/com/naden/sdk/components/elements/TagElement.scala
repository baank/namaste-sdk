package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent}
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TagElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default) extends Component
