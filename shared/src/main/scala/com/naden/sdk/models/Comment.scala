package com.naden.sdk.models

import java.util.UUID
import boopickle.Default._

case class Comment(createdBy: User,
                   comment: String,
                   votes: Int,
                   parent: UUID,
                   children: List[UUID])
    extends Object(createdBy)


object Comment {
	implicit val pickler: Pickler[Comment] = generatePickler[Comment]
}