package com.naden.namaste.ui.models.elements

case class Select(name: String,
                  label: String,
                  placeholder: String,
                  optionGroups: List[OptionGroup],
                  options: List[Option])

case class Option(label: String,
                  value: String,
                  selected: Boolean,
                  disabled: Boolean = false,
                  icon: String = "")

case class OptionGroup(label: String,
                       options: List[Option],
                       disabled: Boolean = false)