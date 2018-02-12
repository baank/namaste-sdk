package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.plugin.PanelType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class PanelSlot(panelType: PanelType,
                     minHeight: Int,
                     createdBy: Option[UUID],
                     createdTime: Instant,
                     updatedBy: Option[UUID],
                     updatedTime: Instant,
                     guid: Option[UUID],
                     status: Status,
                     version: Long,
                     relationships: Map[String, UUID])
	extends Entity with Serializable {

	type EntityType = PanelSlot
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object PanelSlot {
	def apply(panelType: PanelType, minHeight: Int, createdBy: User): PanelSlot = {
		apply(panelType, minHeight, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
