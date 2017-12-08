package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object SelectElement {

  @dom
  def apply(name: String,
            label: String,
            placeholder: String,
            optionGroups: List[SelectOptionGroup],
            options: List[SelectOption]): Binding[Div] = {
    //    <label>@select.label</label>
    //      <select multiple="multiple" class="select">
    //          @for(optionGroup <- select.optionGroups) {
    //          <optgroup label="@optionGroup.label">
    //              @for(option <- optionGroup.options) {
    //              <option value="@option.value" disabled="@if(select.disabled){ disabled }" data-icon="@select.icon" selected="@if(select.selected){ selected }">@option.label</option>
    //              }
    //          </optgroup>
    //              }
    //
    //              @for(option <- select.options) {
    //              <option value="@option.value" disabled="@if(select.disabled){ disabled }" data-icon="@select.icon" selected="@if(select.selected){ selected }">@option.label</option>
    //              }
    //
    //          </select>
    <div></div>
  }

  case class SelectOption(label: String,
                          value: String,
                          selected: Boolean,
                          disabled: Boolean = false,
                          icon: String = "")

  case class SelectOptionGroup(label: String,
                               options: List[SelectOption],
                               disabled: Boolean = false)
}