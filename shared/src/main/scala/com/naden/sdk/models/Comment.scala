package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Comment(comment: String,
                   votes: Int,
                   parent: Option[UUID],
                   children: List[UUID],
                   createdBy: Option[UUID],
                   createdTime: Instant,
                   updatedBy: Option[UUID],
                   updatedTime: Instant,
                   guid: Option[UUID],
                   status: Status,
                   version: Long,
                   relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Comment
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
}

object Comment {
	def apply(comment: String, votes: Int, createdBy: UUID): Comment = {
		apply(comment, votes, None, List(), Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply(comment: String, votes: Int, parent: Option[UUID], children: List[UUID], createdBy: UUID): Comment = {
		apply(comment, votes, parent, children, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}
}