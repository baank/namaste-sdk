package com.naden.sdk.models

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.plugin.{PageType, PanelType}
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
    override val linkedPanelTypes: Set[PanelType] = Set.empty)
    extends PageType {

	val id = UUID.randomUUID()
	def listLayout(parameterValues: Map[ParameterId, String]) = listLayout
    def detailLayout(parameterValues: Map[ParameterId, String]) = detailLayout

    def onStartup(): Unit = {}
    def onShutdown(): Unit = {}

	override def onAppContextChange(newContext: Map[String, _]): Unit = {}
	override def onUserConfigure(newParameterValues: Map[ParameterId, String]): Unit = {}
}