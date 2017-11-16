package com.naden.namaste.ui.models.form

case class FileUpload(name: String,
                      label: String,
                      caption: String,
                  	  restrictedFileTypes: List[String] = List(),
                  	  alwaysDisplayPreview: Boolean = true)