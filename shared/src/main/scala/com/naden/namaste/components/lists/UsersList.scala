package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.User
import com.thoughtworks.binding.dom

case class UsersList(title: String,
            icon: String,
            users: List[User],
            showPosition: Boolean,
            showOnline: Boolean,
            showMessenging: Boolean) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}