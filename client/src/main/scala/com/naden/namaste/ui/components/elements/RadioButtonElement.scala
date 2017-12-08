package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object RadioButtonElement {

  @dom
  def apply(name: String,
            label: String,
            checked: Boolean = false): Binding[Div] = {
    //    @for(radioButton <- radioButtons) {
    //        <div class="radio">
    //            <label><input name="@radioButton.name" type="radio" class="control-primary" checked="@if(radioButton.checked){ checked }">@radioButton.label</label>
    //            </div>
    //            }
    <div></div>
  }
}