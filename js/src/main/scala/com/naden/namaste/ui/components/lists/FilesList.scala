package com.naden.namaste.ui.components.lists

import com.naden.namaste.models.File
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object FilesList {

  @dom
  def apply(title: String,
            icon: String,
            files: List[File],
            showDownload: Boolean,
            showFileSize: Boolean,
            showOwner: Boolean): Binding[Div] = {
    <div></div>
  }
}