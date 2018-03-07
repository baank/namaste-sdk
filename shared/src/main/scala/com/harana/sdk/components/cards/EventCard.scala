package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Event}
import io.circe.generic.JsonCodec

@JsonCodec
case class EventCard(event: Event,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component