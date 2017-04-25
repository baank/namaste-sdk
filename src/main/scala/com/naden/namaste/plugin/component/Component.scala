package com.naden.namaste.plugin.component

import com.naden.namaste.models.Parameter

trait Component {

  // Metadata

  def name(): String

  def description(): String

  def instanceParameters(): Seq[Parameter[AnyRef]]

  def globalParameters(): Seq[Parameter[AnyRef]]


  // Lifecycle

  def onStartup(): Unit

  def onShutdown(): Unit

  def onConfigured(instance: ComponentInstance)

}