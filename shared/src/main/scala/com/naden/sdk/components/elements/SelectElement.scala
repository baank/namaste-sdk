package com.naden.sdk.components.elements

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class SelectElement(name: String,
            label: String,
            placeholder: String,
            optionGroups: List[SelectOptionGroup],
            options: List[SelectOption]) extends Component

@JsonCodec
case class SelectOption(label: String,
                        value: String,
                        selected: Boolean,
                        disabled: Boolean = false,
                        icon: String = "")

@JsonCodec
case class SelectOptionGroup(label: String,
                             options: List[SelectOption],
                             disabled: Boolean = false)
