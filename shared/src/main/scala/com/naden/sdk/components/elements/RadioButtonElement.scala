package com.naden.sdk.components.elements

import com.naden.sdk.components.Component

case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component
