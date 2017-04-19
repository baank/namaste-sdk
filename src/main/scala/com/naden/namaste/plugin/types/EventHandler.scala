package com.naden.namaste.plugin.types

trait EventHandler extends BasePluginType {

  def handleEvent(event: Event)

}
