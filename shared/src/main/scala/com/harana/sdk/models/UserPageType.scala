package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.{EntityId, Excluded}
import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.UserPageType.UserPageTypeId
import com.harana.sdk.plugin.PanelType.PanelTypeId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class UserPageType(
    name: String,
    title: String,
    description: String,
    @Excluded listLayout: Layout,
		@Excluded detailLayout: Layout,
    @Excluded override val instanceParameters: List[Parameter],
    @Excluded override val globalParameters: List[Parameter],
    override val linkedPanelTypes: Set[PanelTypeId] = Set.empty,
    createdBy: Option[UserId],
    createdTime: Instant,
    updatedBy: Option[UserId],
    updatedTime: Instant,
    id: Option[UserPageTypeId],
    status: Status,
    version: Long,
    relationships: Map[String, EntityId])
    extends Entity with Serializable with com.harana.sdk.plugin.PageType {

	def listLayout(parameterValues: Map[ParameterName, ParameterValue]) = listLayout
	def detailLayout(parameterValues: Map[ParameterName, ParameterValue]) = detailLayout

	def onStartup(): Unit = {}
	def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, _]): Unit = {}
	override def onUserConfigure(newParameterValues: Map[ParameterName, ParameterValue]): Unit = {}

	type EntityType = UserPageType
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object UserPageType {
	type UserPageTypeId = UUID
}