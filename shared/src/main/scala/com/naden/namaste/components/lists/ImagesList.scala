package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Image
import com.thoughtworks.binding.dom

case class ImagesList(title: String,
            icon: String,
            images: List[Image],
            columns: Int) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}