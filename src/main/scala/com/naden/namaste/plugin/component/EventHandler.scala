package com.naden.namaste.plugin.component

import com.naden.namaste.models.Event
import com.naden.namaste.plugin.util.ProgressObserver

trait EventHandler extends BaseComponent {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

}
