package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object CheckboxElement {

  @dom
  def apply(name: String,
            label: String,
            checked: Boolean = false): Binding[Div] = {

    //  @for(checkbox <- checkboxes) {
    //    <label><input name="@checkbox.name" type="checkbox" class="control-primary" checked="@if(checkbox.checked){ checked }">@checkbox.label</label>
    //      }

    <div></div>
  }
}
