package com.naden.sdk.models

import java.time.LocalDateTime

import io.circe.generic.JsonCodec
import io.circe.java8.time._

@JsonCodec
case class Event(createdBy: User,
                 title: String,
                 description: String,
                 tags: List[String],
                 startTime: LocalDateTime,
                 endTime: LocalDateTime,
                 attendingUsers: List[User])
    extends Object(createdBy)
