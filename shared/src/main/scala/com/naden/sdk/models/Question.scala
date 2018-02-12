package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Question(title: String,
                    category: String,
                    body: String,
                    votes: Int,
                    createdBy: Option[UUID],
                    createdTime: Instant,
                    updatedBy: Option[UUID],
                    updatedTime: Instant,
                    guid: Option[UUID],
                    status: Status,
                    version: Long,
                    relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Question
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Question {
	def apply(title: String, category: String, body: String, votes: Int, createdBy: User): Question = {
		apply(title, category, body, votes, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
