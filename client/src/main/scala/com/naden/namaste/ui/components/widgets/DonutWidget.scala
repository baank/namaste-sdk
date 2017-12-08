package com.naden.namaste.ui.components.widgets

import com.naden.namaste.ui.components.Value
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object DonutWidget {

  @dom
  def apply(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value]): Binding[Div] = {
    <div></div>
  }
}