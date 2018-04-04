package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.Theme.ThemeId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Theme(title: String,
                         description: String,
                         parameterValues: Map[ParameterId, String],
                         createdBy: Option[UserId],
                         createdTime: Instant,
                         updatedBy: Option[UserId],
                         updatedTime: Instant,
                         id: Option[ThemeId],
                         status: Status,
                         version: Long,
                         relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Theme
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Theme {
	type ThemeId = UUID

	def apply(title: String, description: String, parameterValues: Map[ParameterId, String], createdBy: User): Theme = {
		apply(title, description, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}
}