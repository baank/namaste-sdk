package com.naden.sdk.plugin

abstract class Service {

  def title: String
  def description: String

  // Subclasses to override
  def instanceParameters: List[Parameter]
  def globalParameters: List[Parameter]

  def onStartup(): Unit

  def onShutdown(): Unit

  private var _context: Map[String, _] = Map.empty
  private var _parameterValues: List[(Parameter, String)] = List.empty

  def context = _context

  def parameterValues = _parameterValues

  final def onAppContextChange(newContext: Map[String, _]): Unit = {
    _context = newContext
  }

  final def onUserConfigure(newParameterValues: List[(Parameter, String)]): Unit = {
    _parameterValues = newParameterValues
  }
}
