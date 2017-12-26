package com.naden.namaste.components.elements

import com.naden.namaste.components.Component
import com.thoughtworks.binding.dom

case class FileUploadElement(name: String,
            label: String,
            caption: String,
            restrictedFileTypes: List[String] = List(),
            alwaysDisplayPreview: Boolean = true) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}