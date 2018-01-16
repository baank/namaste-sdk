package com.naden.sdk.plugin

import com.naden.sdk.models.{Parameter, ParameterValue}

trait Service {

  def title: String

  def description: String

  def instanceParameters: List[Parameter]

  def globalParameters: List[Parameter]

  def onStartup(): Unit

  def onShutdown(): Unit

  def onAppContextChange(newContext: Map[String, _]): Unit

  def onUserConfigure(newParameterValues: List[ParameterValue]): Unit

}
