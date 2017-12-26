package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Page
import com.thoughtworks.binding.dom

case class PageCard(page: Page,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}