package com.naden.namaste.ui.models.elements

case class Select(name: String,
                  label: String,
                  placeholder: String,
                  optionGroups: List[SelectOptionGroup],
                  options: List[SelectOption])

case class SelectOption(label: String,
                        value: String,
                        selected: Boolean,
                        disabled: Boolean = false,
                        icon: String = "")

case class SelectOptionGroup(label: String,
                             options: List[SelectOption],
                             disabled: Boolean = false)
