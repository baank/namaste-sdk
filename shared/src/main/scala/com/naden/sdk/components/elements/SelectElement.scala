package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

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


object SelectElement {
	implicit val pickler: Pickler[SelectElement] = generatePickler[SelectElement]
}