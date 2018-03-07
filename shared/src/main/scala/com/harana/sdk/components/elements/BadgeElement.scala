package com.harana.sdk.components.elements

import com.harana.sdk.components.{Color, ColorAccent}
import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component
