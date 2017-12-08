package com.naden.namaste.ui.components.panels

import com.naden.namaste.models.{Comment, User}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object CommentsPanel {

  @dom
  def commentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean): Binding[Div] = {
    <div></div>
  }
}