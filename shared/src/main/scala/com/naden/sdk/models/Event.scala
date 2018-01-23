package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import boopickle.Default._

case class Event(createdBy: User,
                 title: String,
                 description: String,
                 tags: List[String],
                 startTime: LocalDateTime,
                 endTime: LocalDateTime,
                 attendingUsers: List[User])
    extends Object(createdBy)


object Event {
	implicit val pickler: Pickler[Event] = generatePickler[Event]
}