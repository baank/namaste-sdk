package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Parameter
import com.naden.sdk.models.Parameter.ParameterId

trait Service {

  def title: String

  def description: String

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
