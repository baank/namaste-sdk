package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Panel.PanelId
import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.PanelType.PanelTypeId
import com.naden.sdk.plugin.PanelType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Panel(title: String,
                 description: String,
                 panelTypeId: PanelTypeId,
                 parameterValues: Map[ParameterId, String],
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

	def apply(title: String, description: String, panelTypeId: PanelTypeId, parameterValues: Map[ParameterId, String], createdBy: User): Panel = {
		apply(title, description, panelTypeId, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}
}