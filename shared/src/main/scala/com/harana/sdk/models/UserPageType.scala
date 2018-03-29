package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.{EntityId, Excluded}
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.UserPageType.UserPageTypeId
import com.harana.sdk.plugin.PanelType.PanelTypeId
import com.harana.sdk.plugin.PageType
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class UserPageType(
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
    relationships: Map[String, EntityId])
    extends Entity with Serializable with PageType {

	def listLayout(parameterValues: Map[ParameterId, String]) = listLayout
	def detailLayout(parameterValues: Map[ParameterId, String]) = detailLayout

	def onStartup(): Unit = {}
	def onShutdown(): Unit = {}

	override def vendor = "Harana"
	override def version = (1,0,0)

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