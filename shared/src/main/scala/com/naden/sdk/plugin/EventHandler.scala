package com.naden.sdk.plugin

import com.naden.sdk.models.Event
import com.naden.sdk.util.ProgressObserver

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

}
