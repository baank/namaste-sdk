package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.Image
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object ImagesList {

  @dom
  def apply(title: String,
            icon: String,
            images: List[Image],
            columns: Int): Binding[Div] = {
    <div></div>
  }
}