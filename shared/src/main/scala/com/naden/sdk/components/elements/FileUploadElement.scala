package com.naden.sdk.components.elements

import com.naden.sdk.components.Component
import boopickle.Default._

case class FileUploadElement(name: String,
            label: String,
            caption: String,
            restrictedFileTypes: List[String] = List(),
            alwaysDisplayPreview: Boolean = true) extends Component
