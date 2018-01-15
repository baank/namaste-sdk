package com.naden.sdk.models

import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe.Decoder
import io.circe._, io.circe.generic.semiauto._
import com.naden.sdk.util.CirceCodec._

case class UserPageType(
    createdBy: User,
    title: String,
    description: String,
    listLayout: Layout,
    detailLayout: Layout,
    override val instanceParameters: List[Parameter],
    override val globalParameters: List[Parameter],
    override val linkedPanelTypes: Set[PanelType] = Set.empty)
    extends PageType[UserPageType] {

	type T = UserPageType

	def listLayout(parameterValues: List[ParameterValue]) = listLayout
    def detailLayout(parameterValues: List[ParameterValue]) = detailLayout

    def onStartup(): Unit = {}
    def onShutdown(): Unit = {}

    def decoder: Decoder[UserPageType] = deriveDecoder[UserPageType]
	def encoder: Encoder[UserPageType] = deriveEncoder[UserPageType]
}