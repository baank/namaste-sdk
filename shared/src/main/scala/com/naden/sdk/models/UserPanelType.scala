package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.CirceCodecs

case class UserPanelType(
    title: String,
    description: String,
    layout: List[Component],
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val scripts: List[String],
    override val stylesheets: List[String],
    override val userEditable: Boolean,
    override val allowUserRefresh: Boolean,
    createdBy: Option[UserId],
    createdTime: Instant,
    updatedBy: Option[UserId],
    updatedTime: Instant,
    id: Option[UserId],
    status: Status,
    version: Long,
    relationships: Map[String, EntityId])
		extends Entity with Serializable with PanelType {

  override def layout(parameterValues: Map[ParameterId, String]) = layout
  override def layoutHasChanged: Boolean = false

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}

  override def onAppContextChange(newContext: Map[String, _]): Unit = {}
  override def onUserConfigure(newParameterValues: Map[ParameterId, String]): Unit = {}

	type EntityType = UserPanelType
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
	def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object UserPanelType {
	type UserPanelTypeId = UUID
}
