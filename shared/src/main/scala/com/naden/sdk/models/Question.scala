package com.naden.sdk.models

import boopickle.Default._

case class Question(createdBy: User,
                    title: String,
                    category: String,
                    body: String,
                    votes: Int)
    extends Object(createdBy)


object Question {
	implicit val pickler: Pickler[Question] = generatePickler[Question]
}