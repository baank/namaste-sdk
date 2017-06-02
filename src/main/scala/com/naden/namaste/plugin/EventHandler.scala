package com.naden.namaste.plugin

import com.naden.namaste.models.Event
import com.naden.namaste.plugin.util.ProgressObserver

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

}
