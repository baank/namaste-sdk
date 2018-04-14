package com.harana.sdk.components.elements

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class SelectElement(name: String,
            title: String,
            placeholder: String,
            optionGroups: List[SelectOptionGroup],
            options: List[SelectOption]) extends Component

@JsonCodec
case class SelectOption(title: String,
                        value: String,
                        selected: Boolean,
                        disabled: Boolean = false,
                        icon: String = "")

@JsonCodec
case class SelectOptionGroup(title: String,
                             options: List[SelectOption],
                             disabled: Boolean = false)
