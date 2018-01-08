package com.naden.sdk.components.elements

import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.ColorAccent.ColorAccent
import com.naden.sdk.components.{Color, ColorAccent, Component}

case class TagElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default) extends Component
