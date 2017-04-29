package com.naden.namaste.plugin.component

import com.naden.namaste.models.Parameter

trait Component {

  // Metadata
  def name(): String
  def description(): String
  def instanceParameters(): Seq[Parameter[_]]
  def globalParameters(): Seq[Parameter[_]]

  // Lifecycle
  def onStartup(): Unit
  def onShutdown(): Unit
  def onConfigured(instance: ComponentInstance)

}