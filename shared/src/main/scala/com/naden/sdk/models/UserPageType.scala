package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.PanelType.PanelTypeId
import com.naden.sdk.plugin.PageType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class UserPageType(
    title: String,
    description: String,
    listLayout: Layout,
    detailLayout: Layout,
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val linkedPanelTypes: Set[PanelTypeId] = Set.empty,
    createdBy: Option[UserId],
    createdTime: Instant,
    updatedBy: Option[UserId],
    updatedTime: Instant,
    id: Option[UserId],
    status: Status,
    version: Long,
    relationships: Map[String, EntityId])
    extends Entity with Serializable with PageType {

	def listLayout(parameterValues: Map[ParameterId, String]) = listLayout
	def detailLayout(parameterValues: Map[ParameterId, String]) = detailLayout

	def onStartup(): Unit = {}
	def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, _]): Unit = {}
	override def onUserConfigure(newParameterValues: Map[ParameterId, String]): Unit = {}

	type EntityType = UserPageType
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object UserPageType {
	type UserPageTypeId = UUID
}
