package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.models.Component._
import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.BoopickleCodecs._

case class UserPanelType(
    createdBy: User,
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


object UserPanelType {
	implicit val pickler: Pickler[UserPanelType] = generatePickler[UserPanelType]
}