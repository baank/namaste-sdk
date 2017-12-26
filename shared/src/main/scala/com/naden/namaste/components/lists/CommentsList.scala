package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Comment
import com.thoughtworks.binding.dom

case class CommentsList(title: String,
            icon: String,
            comments: List[Comment]) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}