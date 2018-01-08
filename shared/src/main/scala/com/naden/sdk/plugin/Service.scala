package com.naden.sdk.plugin

abstract class Service {

  def title: String
  def description: String

  // Subclasses to override
  def instanceParameters: Seq[Parameter]

  def globalParameters: Seq[Parameter]

  def onStartup(): Unit

  def onShutdown(): Unit

  private var _context: Map[String, _] = Map.empty
  private var _parameterValues: Map[Parameter, _] = Map.empty

  def context = _context

  def parameterValues = _parameterValues

  final def onAppContextChange(newContext: Map[String, _]): Unit = {
    _context = newContext
  }

  final def onUserConfigure(newParameterValues: Map[Parameter, _]): Unit = {
    _parameterValues = newParameterValues
  }
}
