package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Question.QuestionId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Question(title: String,
                    category: String,
                    body: String,
                    votes: Int,
                    createdBy: Option[UserId],
                    createdTime: Instant,
                    updatedBy: Option[UserId],
                    updatedTime: Instant,
                    id: Option[QuestionId],
                    status: Status,
                       relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Question
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Question {
	type QuestionId = UUID

	def apply(title: String, category: String, body: String, votes: Int, createdBy: User): Question = {
		apply(title, category, body, votes, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
	}
}
