package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent, Component}

case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component
