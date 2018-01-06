package com.naden.sdk.plugin.services

import com.naden.sdk.models.Event
import com.naden.sdk.plugin.Service
import com.naden.sdk.plugin.util.ProgressObserver

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

}
