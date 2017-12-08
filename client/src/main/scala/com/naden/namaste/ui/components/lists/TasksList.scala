package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.Tag
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object TasksList {

  @dom
  def apply(title: String,
            icon: String,
            tags: List[Tag]): Binding[Div] = {
    <div></div>
  }
}