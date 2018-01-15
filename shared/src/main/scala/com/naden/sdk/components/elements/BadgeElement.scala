package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent}
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component
