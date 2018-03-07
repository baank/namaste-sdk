package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Event
import com.harana.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

  def decoder: Decoder[_ <: EventHandler]

  def encoder: Encoder[_ <: EventHandler]

}

object EventHandler {
  type EventHandlerId = UUID
}