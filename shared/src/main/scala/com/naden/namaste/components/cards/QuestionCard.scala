package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Question
import com.thoughtworks.binding.dom

case class QuestionCard(question: Question) extends Component {

	@dom def render() = {
		<div>{this.getClass.getName}</div>
	}
}