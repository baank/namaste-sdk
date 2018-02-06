package com.naden.sdk.models

import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class UserPageType(
    createdBy: Option[User],
    title: String,
    description: String,
    listLayout: Layout,
    detailLayout: Layout,
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val linkedPanelTypes: Set[PanelType] = Set.empty)
    extends PageType {

	def listLayout(parameterValues: List[(Parameter, String)]) = listLayout
    def detailLayout(parameterValues: List[(Parameter, String)]) = detailLayout

    def onStartup(): Unit = {}
    def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, _]): Unit = {}
	override def onUserConfigure(newParameterValues: List[(Parameter, String)]): Unit = {}
}