package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.Video.VideoId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Workflow(title: String,
	                  createdBy: Option[UserId],
	                  createdTime: Instant,
	                  updatedBy: Option[UserId],
	                  updatedTime: Instant,
	                  id: Option[VideoId],
	                  status: Status,
	                  version: Long,
                    relationships: Map[String, EntityId])
	  extends Entity with Serializable {

	type EntityType = Workflow
	def copyId(newId: UUID): Workflow = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant): Workflow = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Workflow {
	type WorkflowId = UUID

	def apply(title: String, createdBy: User): Workflow = {
		apply(title, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}
}