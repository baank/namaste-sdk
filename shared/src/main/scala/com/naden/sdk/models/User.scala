package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.{Indexed, Unique}
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class User(firstName: String,
                @Indexed lastName: String,
                @Indexed preferredName: Option[String],
                @Indexed @Unique emailAddress: String,
                title: Option[String],
                groups: Set[UUID],
                thumbnail: Option[String],
                createdBy: Option[UUID],
                createdTime: Instant,
                updatedBy: Option[UUID],
                updatedTime: Instant,
                guid: Option[UUID],
                status: Status,
                version: Long,
                relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = User
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object User {
	def apply(firstName: String, lastName: String, preferredName: Option[String], emailAddress: String, title: Option[String], groups: Set[UUID], thumbnail: Option[String], createdBy: UUID): User = {
		apply(firstName, lastName, preferredName, emailAddress, title, groups, thumbnail, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply(firstName: String, lastName: String, preferredName: Option[String], emailAddress: String, title: Option[String], groups: Set[Group], thumbnail: Option[String]): User = {
		apply(firstName, lastName, preferredName, emailAddress, title, groups.flatMap(_.guid), thumbnail, None, Instant.now, None, Instant.now, None, Status.Active, 1, Map())
	}

	def apply(firstName: String, lastName: String, preferredName: Option[String], emailAddress: String, title: Option[String], groups: Set[Group], thumbnail: Option[String], createdBy: User): User = {
		apply(firstName, lastName, preferredName, emailAddress, title, groups.flatMap(_.guid), thumbnail, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}