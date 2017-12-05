package com.naden.namaste.ui.models.elements

case class FileUploadElement(name: String,
														 label: String,
														 caption: String,
														 restrictedFileTypes: List[String] = List(),
														 alwaysDisplayPreview: Boolean = true)