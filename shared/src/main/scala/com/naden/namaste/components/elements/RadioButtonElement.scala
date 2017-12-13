package com.naden.namaste.components.elements

import com.naden.namaste.components.Component

case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component