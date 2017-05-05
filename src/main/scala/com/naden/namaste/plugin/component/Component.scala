package com.naden.namaste.plugin.component

import com.naden.namaste.models.Parameter

trait Component {

  // Metadata
  val name: String
  val description: String
  val instanceParameters: Seq[Parameter[_]]
  val globalParameters: Seq[Parameter[_]]

  // Lifecycle
  def onStartup(): Unit
  def onShutdown(): Unit
  def onConfigured(instance: ComponentInstance)

}