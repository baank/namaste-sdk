package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.File
import com.thoughtworks.binding.dom

case class FilesList(title: String,
            icon: String,
            files: List[File],
            showDownload: Boolean,
            showFileSize: Boolean,
            showOwner: Boolean) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}