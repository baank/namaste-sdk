package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.{EntityId, Unique}
import com.harana.sdk.models.Page.PageId
import com.harana.sdk.models.Panel.{PanelId, PanelSlotId}
import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.UserPageType.UserPageTypeId
import com.harana.sdk.plugin.PageType.PageTypeId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class Page(name: String,
                title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageTypeId: Either[PageTypeId, UserPageTypeId],
                panels: Map[PanelSlotId, PanelId],
                parameterValues: Map[ParameterName, ParameterValue],
                @Unique linkId: String,
								@Unique space: String,
                parentPage: Option[PageId],
                subPages: List[PageId],
                linkedPages: Map[String, List[PageId]],
                createdBy: Option[UserId],
                createdTime: Instant,
                updatedBy: Option[UserId],
                updatedTime: Instant,
                @Unique id: Option[PageId],
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

	def apply(name: String, title: String, description: String, tags: Set[String], category: String, pageTypeId: Either[PageTypeId, UserPageTypeId], panels: Map[PanelSlotId, Panel], parameterValues: Map[ParameterName, ParameterValue], linkId: String, space: String, createdBy: User): Page = {
		apply(name, title, description, tags, category, pageTypeId, uuidPanels(panels), parameterValues, linkId, space, None, List(), Map(), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1L, Map())
	}

	private def uuidPanels(panels: Map[PanelSlotId, Panel]) = panels.filter { p => p._2.id.isDefined }.map( p => p._1 -> p._2.id.get)
}