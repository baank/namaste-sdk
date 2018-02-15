package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Question.QuestionId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Question(title: String,
                    category: String,
                    body: String,
                    votes: Int,
                    createdBy: Option[UserId],
                    createdTime: Instant,
                    updatedBy: Option[UserId],
                    updatedTime: Instant,
                    guid: Option[QuestionId],
                    status: Status,
                    version: Long,
                    relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Question
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Question {
	type QuestionId = UUID

	def apply(title: String, category: String, body: String, votes: Int, createdBy: User): Question = {
		apply(title, category, body, votes, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
