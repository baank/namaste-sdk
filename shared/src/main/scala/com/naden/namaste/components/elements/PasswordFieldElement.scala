package com.naden.namaste.components.elements

import com.naden.namaste.components.Component

case class PasswordFieldElement(name: String,
            label: String,
            caption: String,
            restrictedFileTypes: List[String] = List(),
            alwaysDisplayPreview: Boolean = true) extends Component