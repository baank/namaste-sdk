package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class MultiSelectElement(name: String,
            label: String,
            optionGroups: List[MultiSelectOptionGroup],
            options: List[MultiSelectOption],
            numberDisplayed: Int,
            nonSelectedText: String,
            includeSelectAllOption: Boolean = false,
            enableFiltering: Boolean = true,
            enableClickableOptionGroups: Boolean = false,
            disableIfEmpty: Boolean = true) extends Component

case class MultiSelectOption(label: String,
                             value: String,
                             selected: Boolean,
                             disabled: Boolean = false,
                             icon: String = "")
case class MultiSelectOptionGroup(label: String,
                                  options: List[MultiSelectOption],
                                  disabled: Boolean = false)


object MultiSelectElement {
	implicit val pickler: Pickler[MultiSelectElement] = generatePickler[MultiSelectElement]
}