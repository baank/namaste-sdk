package com.naden.namaste.ui.components.elements

import com.naden.namaste.ui.components.Color.Color
import com.naden.namaste.ui.components.{Color, ColorAccent, IconSize}
import com.naden.namaste.ui.components.ColorAccent.ColorAccent
import com.naden.namaste.ui.components.IconSize.IconSize
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object ButtonElement {

  @dom
  def apply(name: String,
            label: String,
            size: IconSize = IconSize.DEFAULT,
            color: Color = Color.DEFAULT,
            colorAccent: ColorAccent = ColorAccent.DEFAULT,
            labeled: Boolean = false,
            rounded: Boolean = false,
            floating: Boolean = false): Binding[Div] = {

    //  @for(checkbox <- checkboxes) {
    //    <label><input name="@checkbox.name" type="checkbox" class="control-primary" checked="@if(checkbox.checked){ checked }">@checkbox.label</label>
    //      }

    <div></div>
  }
}