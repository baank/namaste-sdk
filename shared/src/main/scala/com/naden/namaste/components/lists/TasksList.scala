package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Tag
import com.thoughtworks.binding.dom

case class TasksList(title: String,
            icon: String,
            tags: List[Tag]) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}