package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.models.Video.VideoId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Video(title: String,
                 description: String,
                 fileName: String,
                 fileSize: Long,
                 width: Int,
                 height: Int,
                 playTime: Long,
                 mimeType: String,
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 guid: Option[VideoId],
                 status: Status,
                 version: Long,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Video
	def copyGuid(newGuid: UUID): Video = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant): Video = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Video {
	type VideoId = UUID

	def apply(title: String, description: String, fileName: String, fileSize: Long, width: Int, height: Int, playTime: Long, mimeType: String, createdBy: User): Video = {
		apply(title, description, fileName, fileSize, width, height, playTime, mimeType, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
