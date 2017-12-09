package com.naden.namaste.ui.components.elements

import com.naden.namaste.ui.components.{Color, ColorAccent}
import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object BadgeElement {

  @dom
  def apply(title: String,
            color: Color = Color.DEFAULT,
            colorAccent: ColorAccent = ColorAccent.DEFAULT,
            flat: Boolean = false): Binding[Div] = {

    //  @for(checkbox <- checkboxes) {
    //    <label><input name="@checkbox.name" type="checkbox" class="control-primary" checked="@if(checkbox.checked){ checked }">@checkbox.label</label>
    //      }

    <div></div>
  }
}
