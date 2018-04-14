package com.harana.sdk.components.elements

import com.harana.sdk.components.{Color, ColorAccent, IconSize}
import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class ButtonElement(name: String,
            title: String,
            size: IconSize = IconSize.Default,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false) extends Component
