package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import com.naden.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class Event(createdBy: User,
                 title: String,
                 description: String,
                 tags: List[String],
                 startTime: LocalDateTime,
                 endTime: LocalDateTime,
                 attendingUsers: List[User])
    extends Object(createdBy)
