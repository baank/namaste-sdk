package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.Event
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object EventCard {

  @dom
  def apply(event: Event,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String): Binding[Div] = {
    <div>asfasdf</div>
  }
}