package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Group.GroupId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Group(title: String,
                 users: Set[UserId],
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 id: Option[GroupId],
                 status: Status,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Group
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Group {
	type GroupId = UUID

	def apply(title: String, users: Set[User], createdBy: User): Group = {
		apply(title, users.flatMap(_.id), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
	}
}