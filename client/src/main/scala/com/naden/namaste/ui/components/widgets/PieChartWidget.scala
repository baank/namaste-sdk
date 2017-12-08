package com.naden.namaste.ui.components.widgets

import com.naden.namaste.ui.components.Value
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object PieChartWidget {

  @dom
  def apply(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value]): Binding[Div] = {
    <div></div>
  }
}