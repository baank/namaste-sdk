package com.naden.sdk.components.elements

import com.naden.sdk.components.{Color, ColorAccent, Component}

case class LabelElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labelStyle: LabelStyle = LabelStyle.Default,
            icon: String = "") extends Component
            
sealed trait LabelStyle
object LabelStyle {
  case object Default extends LabelStyle
  case object Rounded extends LabelStyle
  case object Square extends LabelStyle
  case object Block extends LabelStyle
  case object Flat extends LabelStyle
}
