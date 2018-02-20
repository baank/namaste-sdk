package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.File.FileId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class File(title: String,
                description: String,
                fileName: String,
                fileSize: Long,
                mimeType: String,
                createdBy: Option[UserId],
                createdTime: Instant,
                updatedBy: Option[UserId],
                updatedTime: Instant,
                id: Option[FileId],
                status: Status,
                version: Long,
                relationships: Map[String, EntityId])
	extends Entity with Serializable {

	type EntityType = File
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object File {
	type FileId = UUID

	def apply(title: String, description: String, fileName: String, fileSize: Long, mimeType: String, createdBy: User): File = {
		apply(title, description, fileName, fileSize, mimeType, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}
}