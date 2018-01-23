package com.naden.sdk.components.cards

import boopickle.Default._
import com.naden.sdk.models.{Component, Event}
import com.naden.sdk.util.BoopickleCodecs._

case class EventCard(event: Event,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component

object EventCard {
	implicit val pickler: Pickler[EventCard] = generatePickler[EventCard]
}