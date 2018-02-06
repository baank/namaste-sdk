package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.CirceCodecs

case class UserPanelType(
    createdBy: Option[User],
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

  override def layout(parameterValues: List[(Parameter, String)]) = layout
  override def layoutHasChanged: Boolean = false

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}

  override def onAppContextChange(newContext: Map[String, _]): Unit = {}
  override def onUserConfigure(newParameterValues: List[(Parameter, String)]): Unit = {}
}
