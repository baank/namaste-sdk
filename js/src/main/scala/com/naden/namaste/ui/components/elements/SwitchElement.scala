package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object SwitchElement {

  @dom
  def apply(name: String,
            label: String,
            checked: Boolean): Binding[Div] = {
    //    <div class="checkbox checkbox-switchery">
    //        <label><input type="checkbox" class="switchery" checked="@if(switch.checked){ checked }">@switch.label</label>
    //        </div>
    <div></div>
  }
}