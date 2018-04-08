package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Panel.PanelId
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.UserPanelType.UserPanelTypeId
import com.harana.sdk.plugin.PanelType.PanelTypeId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Panel(name: String,
                 description: String,
                 panelTypeId: Either[PanelTypeId, UserPanelTypeId],
                 parameterValues: Map[ParameterId, ParameterValue],
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 id: Option[PanelId],
                 status: Status,
                 version: Long,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Panel
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
  def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Panel {
	type PanelSlotId = UUID
	type PanelId = UUID

	def apply(name: String, description: String, panelTypeId: Either[PanelTypeId, UserPanelTypeId], parameterValues: Map[ParameterId, ParameterValue], createdBy: User): Panel = {
		apply(name, description, panelTypeId, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}
}