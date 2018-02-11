package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Group(title: String,
                 users: Set[User],
                 createdBy: Option[UUID],
                 createdTime: Instant,
                 updatedBy: Option[UUID],
                 updatedTime: Instant,
                 guid: Option[UUID],
                 status: Status,
                 version: Long,
                 relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Group
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
}

object Group {
	def apply(title: String, users: Set[User], createdBy: UUID): Group = {
		apply(title, users, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}
}