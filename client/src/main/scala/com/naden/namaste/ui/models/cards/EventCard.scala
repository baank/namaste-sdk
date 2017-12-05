package com.naden.namaste.ui.models.cards

import com.naden.namaste.models.Event

case class EventCard(event: Event,
                     showTitle: Boolean,
                     showSocial: Boolean,
                     showMessaging: Boolean,
                     value: String)
