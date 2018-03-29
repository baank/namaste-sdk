package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Backup.BackupId
import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec

@JsonCodec
case class Backup(createdBy: Option[UserId],
                  createdTime: Instant,
                  updatedBy: Option[UserId],
                  updatedTime: Instant,
                  id: Option[BackupId],
                  status: Status,
                  version: Long,
                  relationships: Map[String, EntityId])
  extends Entity with Serializable {

	type EntityType = Backup
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Backup {
	type BackupId = UUID

	def apply(createdBy: User): Backup = {
		apply(createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}
}
