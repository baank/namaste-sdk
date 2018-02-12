package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

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
                panels: List[(PanelSlot, UUID)],
                parameterValues: List[(Parameter, String)],
                linkId: String,
                parentPage: Option[UUID],
                subPages: List[UUID],
                linkedPages: List[(String, List[UUID])],
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
}

object Page {
	def apply(title: String, description: String, tags: Set[String], category: String, pageType: PageType, panels: List[(PanelSlot, UUID)], parameterValues: List[(Parameter, String)], linkId: String, parentPage: Option[UUID], subPages: List[UUID], linkedPages: List[(String, List[UUID])], createdBy: UUID): Page = {
		apply(title, description, tags, category, pageType, panels, parameterValues, linkId, parentPage, subPages, linkedPages, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply(title: String, description: String, tags: Set[String], category: String, pageType: PageType, panels: List[(PanelSlot, UUID)], parameterValues: List[(Parameter, String)], linkId: String, createdBy: UUID): Page = {
		apply(title, description, tags, category, pageType, panels, parameterValues, linkId, None, List(), List(), Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply(title: String, description: String, tags: Set[String], category: String, pageType: PageType, panels: List[(PanelSlot, UUID)], parameterValues: List[(Parameter, String)], createdBy: UUID): Page = {
		apply(title, description, tags, category, pageType, panels, parameterValues, RandomUtils.id(), None, List(), List(), Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}
}