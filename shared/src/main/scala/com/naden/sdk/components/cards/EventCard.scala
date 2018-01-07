package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.Event
import boopickle.Default._

case class EventCard(event: Event,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component


