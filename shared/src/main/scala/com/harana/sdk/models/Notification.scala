package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Backup.BackupId
import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec

@JsonCodec
case class Notification(createdBy: Option[UserId],
			                  createdTime: Instant,
			                  updatedBy: Option[UserId],
			                  updatedTime: Instant,
			                  id: Option[BackupId],
			                  status: Status,
			                  relationships: Map[String, EntityId])
  extends Entity with Serializable {

	type EntityType = Notification
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Notification {
	type NotificationId = UUID

	def apply(createdBy: User): Notification = {
		apply(createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
	}
}