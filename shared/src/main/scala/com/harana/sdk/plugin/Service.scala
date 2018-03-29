package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Parameter
import com.harana.sdk.models.Parameter.ParameterId

trait Service {

  def title: String

  def description: String

	def vendor: String

	def version: (Int, Int, Int)

  def instanceParameters: List[Parameter]

  def globalParameters: List[Parameter]

  def onStartup(): Unit

  def onShutdown(): Unit

  def onAppContextChange(newContext: Map[String, _]): Unit

  def onUserConfigure(newParameterValues: Map[ParameterId, String]): Unit

}

object Service {
  type ServiceId = UUID
}
