package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Image
import com.thoughtworks.binding.dom

case class ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}

