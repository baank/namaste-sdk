package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.NotificationHandler.NotificationHandlerId
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.util.CirceCodecs._
import io.circe.generic.JsonCodec

@JsonCodec
case class NotificationHandler(name: String,
                               description: String,
                               parameterValues: Map[ParameterId, String],
                               createdBy: Option[UserId],
                               createdTime: Instant,
                               updatedBy: Option[UserId],
                               updatedTime: Instant,
                               id: Option[NotificationHandlerId],
                               status: Status,
                               version: Long,
                               relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = NotificationHandler
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object NotificationHandler {
	type NotificationHandlerId = UUID

	def apply(name: String, description: String, parameterValues: Map[ParameterId, String], createdBy: User): NotificationHandler = {
		apply(name, description, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}
}