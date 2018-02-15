package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Panel.PanelId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Panel(title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: Map[Parameter, String],
                 createdBy: Option[UserId],
                 createdTime: Instant,
                 updatedBy: Option[UserId],
                 updatedTime: Instant,
                 guid: Option[PanelId],
                 status: Status,
                 version: Long,
                 relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Panel
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Panel {
	type PanelSlotId = UUID
	type PanelId = UUID

	def apply(title: String, description: String, panelType: PanelType, parameterValues: Map[Parameter, String], createdBy: User): Panel = {
		apply(title, description, panelType, parameterValues, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}