package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class Event(title: String,
                 description: String,
                 tags: List[String],
                 startTime: Instant,
                 endTime: Instant,
                 attendingUsers: List[UUID],
                 createdBy: Option[UUID],
                 createdTime: Instant,
                 updatedBy: Option[UUID],
                 updatedTime: Instant,
                 guid: Option[UUID],
                 status: Status,
                 version: Long,
                 relationships: Map[String, UUID])
	extends Entity with Serializable {

	type EntityType = Event
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Event {
	def apply(title: String, description: String, tags: List[String], startTime: Instant, endTime: Instant, attendingUsers: List[UUID], createdBy: UUID): Event = {
		apply(title, description, tags, startTime, endTime, attendingUsers, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply(title: String, description: String, tags: List[String], startTime: Instant, endTime: Instant, attendingUsers: List[User], createdBy: User): Event = {
		apply(title, description, tags, startTime, endTime, attendingUsers.flatMap(_.guid), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
