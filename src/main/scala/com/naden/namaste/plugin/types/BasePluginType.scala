package com.naden.namaste.plugin.types

import com.naden.namaste.models.Property

trait BasePluginType {

  // Metadata
  var name: String
  var description: String
  var properties: List[Property]

  // Lifecycle
  def onCreate(): Boolean
  def onDestroy(): Boolean
  def onConfigure(properties: Map[Property, AnyRef])

}
