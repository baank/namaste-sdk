package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.User
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object UserCard {

  @dom
  def apply(user: User,
            showIcon: Boolean,
            showPosition: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean): Binding[Div] = {
    <div></div>
  }
}