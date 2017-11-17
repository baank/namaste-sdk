package com.naden.namaste.ui.models.elements

case class MultiSelect(name: String,
                       label: String,
                       optionGroups: List[MultiSelectOptionGroup],
                  	   options: List[MultiSelectOption],
                       numberDisplayed: Int,
                       nonSelectedText: String,
                       includeSelectAllOption: Boolean = false,
                       enableFiltering: Boolean = true,
                       enableClickableOptionGroups: Boolean = false,
                       disableIfEmpty: Boolean = true)

case class MultiSelectOption(label: String,
                        	 value: String,
                        	 selected: Boolean,
                        	 disabled: Boolean = false,
                        	 icon: String = "")

case class MultiSelectOptionGroup(label: String,
                             	  options: List[MultiSelectOption],
                             	  disabled: Boolean = false)