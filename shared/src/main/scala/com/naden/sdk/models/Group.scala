package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Group.GroupId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Group(title: String,
                 users: Set[UserId],
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 guid: Option[GroupId],
                 status: Status,
                 version: Long,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Group
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Group {
	type GroupId = UUID

	def apply(title: String, users: Set[User], createdBy: User): Group = {
		apply(title, users.flatMap(_.guid), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}