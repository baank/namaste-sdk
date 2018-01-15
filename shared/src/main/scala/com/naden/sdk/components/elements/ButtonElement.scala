package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent, IconSize}
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class ButtonElement(name: String,
            label: String,
            size: IconSize = IconSize.Default,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false) extends Component
