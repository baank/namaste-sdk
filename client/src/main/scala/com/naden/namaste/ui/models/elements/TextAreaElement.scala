package com.naden.namaste.ui.models.elements

case class TextAreaElement(name: String,
                           rows: Int,
                           columns: Int,
                           placeholder: String = "",
                           value: String = "")
