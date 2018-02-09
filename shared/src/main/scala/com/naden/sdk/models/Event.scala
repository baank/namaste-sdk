package com.naden.sdk.models

import java.time.Instant
import com.naden.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class Event(createdBy: Option[User],
                 title: String,
                 description: String,
                 tags: List[String],
                 startTime: Instant,
                 endTime: Instant,
                 attendingUsers: List[User])
    extends Entity with Serializable
