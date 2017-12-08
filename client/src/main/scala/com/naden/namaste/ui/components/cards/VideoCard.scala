package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.Video
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object VideoCard {

  @dom
  def apply(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean): Binding[Div] = {
    <div></div>
  }
}