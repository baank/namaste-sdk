package com.naden.namaste.ui.components.elements

import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.naden.namaste.ui.components.elements.LabelElement.LabelStyle.LabelStyle
import com.naden.namaste.ui.components.{Color, ColorAccent}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Span

object LabelElement {

  @dom
  def apply(title: String,
            color: Color = Color.DEFAULT,
            colorAccent: ColorAccent = ColorAccent.DEFAULT,
            labelStyle: LabelStyle = LabelStyle.DEFAULT,
            icon: String): Binding[Span] = {

    val colorCls = s"bg-${color.toString}-${colorAccent.toString}"
    val styleCls = labelStyle.toString

    <span class={s"label $colorCls $styleCls"}>
      {title}
    </span>
  }

  object LabelStyle extends Enumeration {
    type LabelStyle = Value
    val DEFAULT = Value("")
    val ROUNDED = Value("label-rounded")
    val SQUARE = Value("label-roundless")
    val BLOCK = Value("label-block")
    val FLAT = Value("label-flat")
  }
}