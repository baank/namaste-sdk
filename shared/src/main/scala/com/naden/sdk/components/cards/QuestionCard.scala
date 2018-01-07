package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.Question
import boopickle.Default._

case class QuestionCard(question: Question) extends Component
