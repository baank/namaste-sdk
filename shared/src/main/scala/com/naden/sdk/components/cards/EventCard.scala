package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Event}
import io.circe.generic.JsonCodec

@JsonCodec
case class EventCard(event: Event,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component


