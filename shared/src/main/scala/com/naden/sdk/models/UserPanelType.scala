package com.naden.sdk.models

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.CirceCodecs

case class UserPanelType(
    createdBy: Option[UserId],
    title: String,
    description: String,
    layout: List[Component],
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val scripts: List[String],
    override val stylesheets: List[String],
    override val userEditable: Boolean,
    override val allowUserRefresh: Boolean)
    extends PanelType {

  val id = UUID.randomUUID()
  override def layout(parameterValues: Map[ParameterId, String]) = layout
  override def layoutHasChanged: Boolean = false

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}

  override def onAppContextChange(newContext: Map[String, _]): Unit = {}
  override def onUserConfigure(newParameterValues: Map[ParameterId, String]): Unit = {}
}