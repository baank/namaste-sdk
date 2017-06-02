package com.naden.namaste.plugin

import com.naden.namaste.models.Parameter
import com.naden.namaste.plugin.util.Localized

trait Service extends Localized {

  def instanceParameters: Seq[Parameter[_]]
  def globalParameters: Seq[Parameter[_]]

  // Lifecycle
  def onStartup(): Unit
  def onShutdown(): Unit
  def onConfigured(parameters: Map[Parameter[_], _]): Unit

}
