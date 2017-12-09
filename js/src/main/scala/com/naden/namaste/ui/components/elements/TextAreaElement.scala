package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object TextAreaElement {

  @dom
  def apply(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = ""): Binding[Div] = {
    //  <textarea name="@textArea.name" rows="@textArea.rows" cols="@textArea.columns" class="form-control elastic" placeholder="@textArea.placeholder">@textArea.value</textarea>
    <div></div>
  }
}