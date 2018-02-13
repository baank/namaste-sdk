package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Page.uuidPanels
import com.naden.sdk.plugin.PageType
import com.naden.sdk.util.RandomUtils
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Page(title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageType: PageType,
                panels: Map[UUID, UUID],
                parameterValues: Map[Parameter, String],
                linkId: String,
                parentPage: Option[UUID],
                subPages: List[UUID],
                linkedPages: Map[String, List[UUID]],
                createdBy: Option[UUID],
                createdTime: Instant,
                updatedBy: Option[UUID],
                updatedTime: Instant,
                guid: Option[UUID],
                status: Status,
                version: Long,
                relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = Page
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Page {
	def apply(title: String, description: String, tags: Set[String], category: String, pageType: PageType, panels: Map[PanelSlot, Panel], parameterValues: Map[Parameter, String], linkId: String, createdBy: User): Page = {
		apply(title, description, tags, category, pageType, uuidPanels(panels), parameterValues, linkId, None, List(), Map(), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}

	def apply(title: String, description: String, tags: Set[String], category: String, pageType: PageType, panels: Map[PanelSlot, Panel], parameterValues: Map[Parameter, String], createdBy: User): Page = {
		apply(title, description, tags, category, pageType, uuidPanels(panels), parameterValues, RandomUtils.id(), None, List(), Map(), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}

	private def uuidPanels(panels: Map[PanelSlot, Panel]) = panels.filter { p => p._1.guid.isDefined && p._2.guid.isDefined }.map( p => p._1.guid.get -> p._2.guid.get)
}