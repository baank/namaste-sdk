package com.naden.namaste.components.panels

import com.naden.namaste.components.Component
import com.naden.namaste.models.{Comment, User}
import com.thoughtworks.binding.dom

case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}