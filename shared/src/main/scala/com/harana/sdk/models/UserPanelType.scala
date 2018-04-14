package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.{EntityId, Excluded}
import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.UserPanelType.UserPanelTypeId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class UserPanelType(
    name: String,
    title: String,
    description: String,
		@Excluded layout: List[Component],
    @Excluded override val instanceParameters: List[Parameter],
    @Excluded override val globalParameters: List[Parameter],
    override val scripts: List[String],
    override val stylesheets: List[String],
    override val userEditable: Boolean,
    override val allowUserRefresh: Boolean,
    createdBy: Option[UserId],
    createdTime: Instant,
    updatedBy: Option[UserId],
    updatedTime: Instant,
    id: Option[UserPanelTypeId],
    status: Status,
    version: Long,
    relationships: Map[String, EntityId])
		extends Entity with Serializable with com.harana.sdk.plugin.PanelType {

  override def layout(parameterValues: Map[ParameterName, ParameterValue]) = layout
  override def layoutHasChanged: Boolean = false

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, _]): Unit = {}
  override def onUserConfigure(newParameterValues: Map[ParameterName, ParameterValue]): Unit = {}

	type EntityType = UserPanelType
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object UserPanelType {
	type UserPanelTypeId = UUID
}