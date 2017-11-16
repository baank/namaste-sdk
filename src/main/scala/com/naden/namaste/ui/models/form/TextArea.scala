package com.naden.namaste.ui.models.form

case class TextArea(name: String,
                    rows: Int,
                    columns: Int,
                    placeholder: String = "",
                    value: String = "")
