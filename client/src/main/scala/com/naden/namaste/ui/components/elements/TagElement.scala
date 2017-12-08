package com.naden.namaste.ui.components.elements

import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.naden.namaste.ui.components.{Color, ColorAccent}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Span

object TagElement {

  @dom
  def apply(title: String,
            color: Color = Color.DEFAULT,
            colorAccent: ColorAccent = ColorAccent.DEFAULT): Binding[Span] = {

    <span class="label bg-">
      {title}
    </span>
  }
}