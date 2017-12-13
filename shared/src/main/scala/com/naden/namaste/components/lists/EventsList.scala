package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Event

case class EventsList(title: String,
            icon: String,
            events: List[Event]) extends Component