package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Component, File}

case class FilesList(title: String,
            icon: String,
            files: List[File] = List.empty,
            showDownload: Boolean = false,
            showFileSize: Boolean = false,
            showOwner: Boolean = false) extends Component


object FilesList {
	implicit val pickler: Pickler[FilesList] = generatePickler[FilesList]
}