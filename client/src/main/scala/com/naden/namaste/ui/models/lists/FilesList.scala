package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.File

case class FilesList(title: String,
                     icon: String,
                     files: List[File],
                     showDownload: Boolean,
                     showFileSize: Boolean,
                     showOwner: Boolean)