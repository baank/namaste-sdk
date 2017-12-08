package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.Event
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object EventsList {

  @dom
  def apply(title: String,
            icon: String,
            events: List[Event]): Binding[Div] = {
    <div></div>
  }
}