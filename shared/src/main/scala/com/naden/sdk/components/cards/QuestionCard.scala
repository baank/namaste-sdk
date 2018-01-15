package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Question}
import io.circe.generic.JsonCodec

@JsonCodec
case class QuestionCard(question: Question) extends Component
