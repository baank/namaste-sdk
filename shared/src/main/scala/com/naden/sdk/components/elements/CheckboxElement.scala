package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class CheckboxElement(name: String,
            label: String,
            checked: Boolean = false) extends Component
