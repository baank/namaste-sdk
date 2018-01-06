package com.naden.sdk.components.elements

import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.{Color, ColorAccent, Component}
import com.naden.sdk.components.ColorAccent.ColorAccent
import com.naden.sdk.components.elements.LabelStyle.LabelStyle

case class LabelElement(title: String,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            labelStyle: LabelStyle = LabelStyle.Default,
            icon: String = "") extends Component
            
case object LabelStyle extends Enumeration {
  type LabelStyle = Value
  val Default = Value
  val Rounded = Value
  val Square = Value
  val Block = Value
  val Flat = Value
}
