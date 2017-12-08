package com.naden.namaste.ui.components.cards

import com.naden.namaste.models.Question
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object QuestionCard {

  @dom
  def apply(question: Question): Binding[Div] = {
    <div></div>
  }
}