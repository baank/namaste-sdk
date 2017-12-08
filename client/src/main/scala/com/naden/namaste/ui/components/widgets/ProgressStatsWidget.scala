package com.naden.namaste.ui.components.widgets

import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.naden.namaste.ui.components.{Percentage, Value}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object ProgressStatsWidget {

  @dom
  def apply(title: String,
            subtitle: String,
            percentages: List[Percentage],
            circular: Boolean,
            icon: Option[String],
            color: Color,
            colorAccent: ColorAccent,
            coloredBackground: Boolean,
            relatedValues: List[Value]): Binding[Div] = {
    <div></div>
  }

  object ProgressStyle extends Enumeration {
    type GaugeStyle = Value
    val HORIZONTAL = Value
    val CIRCULAR = Value
    val HALF = Value
    val SPEEDOMETER = Value
  }
}