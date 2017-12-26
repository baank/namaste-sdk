package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class SelectElement(name: String,
            label: String,
            placeholder: String,
            optionGroups: List[SelectOptionGroup],
            options: List[SelectOption]) extends Component {

	@dom def render() = {
		<select multiple="multiple" data-placeholder="{ placeholder }" class="select-size-sm"> {
			for (option <- options) yield {
				<option value="CO">Colorado</option>
			}

			for (optionGroup <- optionGroups) yield {
				<optgroup label="{ optionGroup.label }"> {

					for (optionGroupOption <- optionGroup.options) yield {
						<option value="{ optionGroupOption.value }">{ optionGroupOption.label }</option>
					}
				}
				</optgroup>
			}
		}
		</select>
	}
}

case class SelectOption(label: String,
                        value: String,
                        selected: Boolean,
                        disabled: Boolean = false,
                        icon: String = "")

case class SelectOptionGroup(label: String,
                             options: List[SelectOption], Boolean = false)