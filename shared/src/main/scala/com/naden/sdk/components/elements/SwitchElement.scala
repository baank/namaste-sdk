package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class SwitchElement(name: String,
            label: String,
            checked: Boolean) extends Component
