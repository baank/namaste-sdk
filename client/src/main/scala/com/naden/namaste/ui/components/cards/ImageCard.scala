package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.Image
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object ImageCard {

  @dom
  def apply(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean): Binding[Div] = {
    <div></div>
  }
}