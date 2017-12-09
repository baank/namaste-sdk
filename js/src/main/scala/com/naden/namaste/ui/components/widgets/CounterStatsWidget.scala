package com.naden.namaste.ui.components.widgets

import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.naden.namaste.ui.components.IconPosition.IconPosition
import com.naden.namaste.ui.components.{Color, ColorAccent, IconPosition, Value}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object CounterStatsWidget {

  @dom
  def apply(value: String,
            valueName: String,
            icon: String,
            iconPosition: IconPosition = IconPosition.LEFT,
            color: Color = Color.DEFAULT,
            colorAccent: ColorAccent = ColorAccent.DEFAULT,
            coloredBackground: Boolean = false,
            relatedValues: List[Value]): Binding[Div] = {
    <div></div>
  }
}