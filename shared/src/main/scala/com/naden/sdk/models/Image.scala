package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Image(title: String,
                 description: String,
                 fileName: String,
                 fileSize: Long,
                 width: Int,
                 height: Int,
                 mimeType: String,
                 createdBy: Option[UUID],
                 createdTime: Instant,
                 updatedBy: Option[UUID],
                 updatedTime: Instant,
                 guid: Option[UUID],
                 status: Status,
                 version: Long,
                 relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Image
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
}

object Image {
	def apply(title: String, description: String, fileName: String, fileSize: Long, width: Int, height: Int, mimeType: String, createdBy: UUID): Image = {
		apply(title, description, fileName, fileSize, width, height, mimeType, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}
}
