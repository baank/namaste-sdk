package com.naden.sdk.components.elements

import boopickle.Default._

import com.naden.sdk.models.Component

case class FileUploadElement(name: String,
            label: String,
            caption: String,
            restrictedFileTypes: List[String] = List(),
            alwaysDisplayPreview: Boolean = true) extends Component


object FileUploadElement {
	implicit val pickler: Pickler[FileUploadElement] = generatePickler[FileUploadElement]
}