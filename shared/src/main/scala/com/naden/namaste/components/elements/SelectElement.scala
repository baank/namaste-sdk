package com.naden.namaste.components.elements

import com.naden.namaste.components.Component

case class SelectElement(name: String,
            label: String,
            placeholder: String,
            optionGroups: List[SelectOptionGroup],
            options: List[SelectOption]) extends Component

case class SelectOption(label: String,
                        value: String,
                        selected: Boolean,
                        disabled: Boolean = false,
                        icon: String = "")

case class SelectOptionGroup(label: String,
                             options: List[SelectOption],
                             disabled: Boolean = false)