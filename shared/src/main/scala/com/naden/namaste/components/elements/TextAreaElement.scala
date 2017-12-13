package com.naden.namaste.components.elements

import com.naden.namaste.components.Component

case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component