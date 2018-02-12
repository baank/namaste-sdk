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
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Comment {
	def apply(comment: String, votes: Int, createdBy: User): Comment = {
		apply(comment, votes, None, List(), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}

	def apply(comment: String, votes: Int, parent: Comment, children: List[Comment], createdBy: User): Comment = {
		apply(comment, votes, parent.guid, children.flatMap(_.guid), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}