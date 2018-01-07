package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class RadioButtonElement(name: String,
            label: String,
            checked: Boolean = false) extends Component
