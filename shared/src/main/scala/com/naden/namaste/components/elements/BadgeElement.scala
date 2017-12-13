package com.naden.namaste.components.elements

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.{Color, ColorAccent, Component}
import com.naden.namaste.components.ColorAccent.ColorAccent

case class BadgeElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            flat: Boolean = false) extends Component