package com.naden.sdk.models

import java.util.UUID


import io.circe.generic.JsonCodec

@JsonCodec
case class Comment(createdBy: User,
                   comment: String,
                   votes: Int,
                   parent: UUID,
                   children: List[UUID])
    extends Object(createdBy)
