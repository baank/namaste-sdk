package com.naden.sdk.components.elements

import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.ColorAccent.ColorAccent
import com.naden.sdk.components.IconSize.IconSize
import com.naden.sdk.components.{Color, ColorAccent, Component, IconSize}

case class ButtonElement(name: String,
            label: String,
            size: IconSize = IconSize.Default,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false) extends Component
