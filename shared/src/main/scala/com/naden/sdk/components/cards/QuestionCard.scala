package com.naden.sdk.components.cards

import boopickle.Default._

import com.naden.sdk.models.{Component, Question}

case class QuestionCard(question: Question) extends Component


object QuestionCard {
	implicit val pickler: Pickler[QuestionCard] = generatePickler[QuestionCard]
}