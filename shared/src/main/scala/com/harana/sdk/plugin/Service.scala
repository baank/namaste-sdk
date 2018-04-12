package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.{Parameter, ParameterValue}
import com.harana.sdk.models.Parameter.ParameterName

trait Service {

  def name: String

	def label: String

  def description: String

  def instanceParameters: List[Parameter]

  def globalParameters: List[Parameter]

  def onStartup(): Unit

  def onShutdown(): Unit

  def onAppContextChange(newContext: Map[String, _]): Unit

  def onUserConfigure(newParameterValues: Map[ParameterName, ParameterValue]): Unit

}

object Service {
	type ServiceId = UUID
}