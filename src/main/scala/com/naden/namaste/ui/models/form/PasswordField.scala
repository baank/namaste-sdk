package com.naden.namaste.ui.models.form

case class PasswordField(name: String,
                         label: String,
                         caption: String,
                         restrictedFileTypes: List[String] = List(),
                         alwaysDisplayPreview: Boolean = true)