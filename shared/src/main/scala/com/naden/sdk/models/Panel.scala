package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Panel(title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: List[(Parameter, String)],
                 createdBy: Option[UUID],
                 createdTime: Instant,
                 updatedBy: Option[UUID],
                 updatedTime: Instant,
                 guid: Option[UUID],
                 status: Status,
                 version: Long,
                 relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Panel
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
}

object Panel {
	def apply(title: String, description: String, panelType: PanelType, parameterValues: List[(Parameter, String)], createdBy: UUID): Panel = {
		apply(title, description, panelType, parameterValues, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}
}