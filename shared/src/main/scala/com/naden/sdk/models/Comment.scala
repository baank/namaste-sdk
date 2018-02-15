package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Comment.CommentId
import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Comment(comment: String,
                   votes: Int,
                   parent: Option[CommentId],
                   children: List[CommentId],
                   createdBy: Option[UserId],
                   createdTime: Instant,
                   updatedBy: Option[UserId],
                   updatedTime: Instant,
                   guid: Option[CommentId],
                   status: Status,
                   version: Long,
                   relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Comment
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Comment {
	type CommentId = UUID

	def apply(comment: String, votes: Int, createdBy: User): Comment = {
		apply(comment, votes, None, List(), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}

	def apply(comment: String, votes: Int, parent: Comment, children: List[Comment], createdBy: User): Comment = {
		apply(comment, votes, parent.guid, children.flatMap(_.guid), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}