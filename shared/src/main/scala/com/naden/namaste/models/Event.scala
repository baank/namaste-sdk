package com.naden.namaste.models

import java.time.LocalDateTime

case class Event(createdBy: User,
                 title: String,
                 description: String,
                 tags: List[String],
                 startTime: LocalDateTime,
                 endTime: LocalDateTime,
                 attendingUsers: List[User])
    extends Object(createdBy)
