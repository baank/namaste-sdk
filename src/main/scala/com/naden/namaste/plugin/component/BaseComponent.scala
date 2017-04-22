package com.naden.namaste.plugin.component

import com.naden.namaste.models.Parameter

trait BaseComponent {

  // Metadata

  def name(): String

  def description(): String

  def configurationProperties: Seq[Parameter[AnyRef]]


  // Lifecycle

  def onStartup(): Boolean

  def onShutdown(): Boolean

  def onConfigure(propertyValues: Map[Parameter[AnyRef], AnyRef])

}