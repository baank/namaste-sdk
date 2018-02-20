package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Page.PageId
import com.naden.sdk.models.Panel.{PanelId, PanelSlotId}
import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.PageType
import com.naden.sdk.plugin.PageType.PageTypeId
import com.naden.sdk.util.RandomUtils
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Page(title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageTypeId: PageTypeId,
                panels: Map[PanelSlotId, PanelId],
                parameterValues: Map[ParameterId, String],
                linkId: String,
                parentPage: Option[PageId],
                subPages: List[PageId],
                linkedPages: Map[String, List[PageId]],
                createdBy: Option[UserId],
                createdTime: Instant,
                updatedBy: Option[UserId],
                updatedTime: Instant,
                id: Option[PageId],
                status: Status,
                version: Long,
                relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = Page
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Page {
	type PageId = UUID

	def apply(title: String, description: String, tags: Set[String], category: String, pageTypeId: PageTypeId, panels: Map[PanelSlotId, Panel], parameterValues: Map[ParameterId, String], linkId: String, createdBy: User): Page = {
		apply(title, description, tags, category, pageTypeId, uuidPanels(panels), parameterValues, linkId, None, List(), Map(), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}

	def apply(title: String, description: String, tags: Set[String], category: String, pageTypeId: PageTypeId, panels: Map[PanelSlotId, Panel], parameterValues: Map[ParameterId, String], createdBy: User): Page = {
		apply(title, description, tags, category, pageTypeId, uuidPanels(panels), parameterValues, RandomUtils.id(), None, List(), Map(), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}

	private def uuidPanels(panels: Map[PanelSlotId, Panel]) = panels.filter { p => p._2.id.isDefined }.map( p => p._1 -> p._2.id.get)
}