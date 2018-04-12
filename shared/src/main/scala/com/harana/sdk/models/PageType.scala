package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.PageType.PageTypeId
import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class PageType(name: String,
                    description: String,
                    parameterValues: Map[ParameterName, String],
                    createdBy: Option[UserId],
                    createdTime: Instant,
                    updatedBy: Option[UserId],
                    updatedTime: Instant,
                    id: Option[PageTypeId],
                    status: Status,
                    version: Long,
                    relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = PageType
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object PageType {
	type PageTypeId = UUID

	def apply(name: String, description: String, parameterValues: Map[ParameterName, String], createdBy: User): PageType = {
		apply(name, description, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}
}