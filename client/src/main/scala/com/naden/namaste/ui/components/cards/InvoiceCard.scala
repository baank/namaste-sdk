package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.User
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object InvoiceCard {

  @dom
  def apply(user: User,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String): Binding[Div] = {
    <div></div>
  }
}