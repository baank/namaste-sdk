package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component
