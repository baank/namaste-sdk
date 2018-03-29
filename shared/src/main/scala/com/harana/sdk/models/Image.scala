package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Image.ImageId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Image(title: String,
                 description: String,
                 fileName: String,
                 fileSize: Long,
                 width: Int,
                 height: Int,
                 mimeType: String,
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 id: Option[ImageId],
                 status: Status,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Image
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Image {
	type ImageId = UUID

	def apply(title: String, description: String, fileName: String, fileSize: Long, width: Int, height: Int, mimeType: String, createdBy: User): Image = {
		apply(title, description, fileName, fileSize, width, height, mimeType, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
	}
}
