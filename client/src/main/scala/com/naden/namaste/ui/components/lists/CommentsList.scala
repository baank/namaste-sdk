package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.Comment
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object CommentsList {

  @dom
  def apply(title: String,
            icon: String,
            comments: List[Comment]): Binding[Div] = {
    <div></div>
  }
}