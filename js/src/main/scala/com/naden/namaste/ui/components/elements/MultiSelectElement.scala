package com.naden.namaste.ui.components.elements

import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object MultiSelectElement {

  @dom
  def apply(name: String,
            label: String,
            optionGroups: List[MultiSelectOptionGroup],
            options: List[MultiSelectOption],
            numberDisplayed: Int,
            nonSelectedText: String,
            includeSelectAllOption: Boolean = false,
            enableFiltering: Boolean = true,
            enableClickableOptionGroups: Boolean = false,
            disableIfEmpty: Boolean = true): Binding[Div] = {
    <div></div>
  }

  case class MultiSelectOption(label: String,
                               value: String,
                               selected: Boolean,
                               disabled: Boolean = false,
                               icon: String = "")

  case class MultiSelectOptionGroup(label: String,
                                    options: List[MultiSelectOption],
                                    disabled: Boolean = false)
}