package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.{EntityId, Indexed, Unique}
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class User(firstName: String,
                @Indexed lastName: String,
                @Indexed preferredName: Option[String],
                @Indexed @Unique emailAddress: String,
                title: Option[String],
                groups: Set[UserId],
                thumbnail: Option[String],
                createdBy: Option[UserId],
                createdTime: Instant,
                updatedBy: Option[UserId],
                updatedTime: Instant,
                id: Option[UserId],
                status: Status,
                relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = User
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object User {
	type UserId = UUID

	def apply(firstName: String, lastName: String, preferredName: Option[String], emailAddress: String, title: Option[String], groups: Set[Group], thumbnail: Option[String]): User = {
		apply(firstName, lastName, preferredName, emailAddress, title, groups.flatMap(_.id), thumbnail, None, Instant.now, None, Instant.now, None, Status.Active, Map())
	}

	def apply(firstName: String, lastName: String, preferredName: Option[String], emailAddress: String, title: Option[String], groups: Set[Group], thumbnail: Option[String], createdBy: User): User = {
		apply(firstName, lastName, preferredName, emailAddress, title, groups.flatMap(_.id), thumbnail, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
	}
}