package com.harana.sdk.plugin

import java.util.UUID
import com.harana.sdk.models.Event
import com.harana.sdk.util.ProgressObserver

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

}

object EventHandler {
  type EventHandlerId = UUID
}