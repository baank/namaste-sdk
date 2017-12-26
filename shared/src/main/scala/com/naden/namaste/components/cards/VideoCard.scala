package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Video
import com.thoughtworks.binding.dom

case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component {


	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}