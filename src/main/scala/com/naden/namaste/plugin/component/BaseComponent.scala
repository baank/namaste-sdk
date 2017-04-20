package com.naden.namaste.plugin.component

import com.naden.namaste.models.Property

trait BaseComponent {

  // Metadata

  def name(): String

  def description(): String

  def configurationProperties: Seq[Property[AnyRef]]


  // Lifecycle

  def onStartup(): Boolean

  def onShutdown(): Boolean

  def onConfigure(propertyValues: Map[Property[AnyRef], AnyRef])

}