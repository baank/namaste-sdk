package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Question}
import io.circe.generic.JsonCodec

@JsonCodec
case class QuestionCard(question: Question) extends Component
