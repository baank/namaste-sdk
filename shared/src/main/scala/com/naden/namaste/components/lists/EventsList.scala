package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Event
import com.thoughtworks.binding.dom

case class EventsList(title: String,
            icon: String,
            events: List[Event]) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}