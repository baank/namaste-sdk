package com.naden.namaste.models

import java.util.UUID

case class Comment(comment: String,
                   createdBy: User,
                   votes: Int,
                   parent: UUID,
                   children: List[UUID])
  extends Object(createdBy)