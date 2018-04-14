package com.harana.sdk.components.elements

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class MultiSelectElement(name: String,
            title: String,
            optionGroups: List[MultiSelectOptionGroup],
            options: List[MultiSelectOption],
            numberDisplayed: Int,
            nonSelectedText: String,
            includeSelectAllOption: Boolean = false,
            enableFiltering: Boolean = true,
            enableClickableOptionGroups: Boolean = false,
            disableIfEmpty: Boolean = true) extends Component

@JsonCodec
case class MultiSelectOption(title: String,
                             value: String,
                             selected: Boolean,
                             disabled: Boolean = false,
                             icon: String = "")
@JsonCodec
case class MultiSelectOptionGroup(title: String,
                                  options: List[MultiSelectOption],
                                  disabled: Boolean = false)
