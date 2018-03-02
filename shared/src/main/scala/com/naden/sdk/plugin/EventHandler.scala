package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Event
import com.naden.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

trait EventHandler extends Service {

  def handleEvent(event: Event, progressObserver: ProgressObserver)

  def decoder: Decoder[_ <: EventHandler]

  def encoder: Encoder[_ <: EventHandler]

}

object EventHandler {
  type EventHandlerId = UUID
}