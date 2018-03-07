package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Event.EventId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class Event(title: String,
                 description: String,
                 tags: List[String],
                 startTime: Instant,
                 endTime: Instant,
                 attendingUsers: List[UserId],
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 id: Option[EventId],
                 status: Status,
                 version: Long,
                 relationships: Map[String, EntityId])
	extends Entity with Serializable {

	type EntityType = Event
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Event {
	type EventId = UUID

	def apply(title: String, description: String, tags: List[String], startTime: Instant, endTime: Instant, attendingUsers: List[User], createdBy: User): Event = {
		apply(title, description, tags, startTime, endTime, attendingUsers.flatMap(_.id), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}
}
