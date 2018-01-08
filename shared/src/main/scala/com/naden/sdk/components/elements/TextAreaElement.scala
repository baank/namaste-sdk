package com.naden.sdk.components.elements

import com.naden.sdk.components.Component

case class TextAreaElement(name: String,
            rows: Int,
            columns: Int,
            placeholder: String = "",
            value: String = "") extends Component
