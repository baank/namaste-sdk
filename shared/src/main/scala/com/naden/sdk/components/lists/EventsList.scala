package com.naden.sdk.components.lists

import com.naden.sdk.components.Component
import com.naden.sdk.models.Event
import boopickle.Default._

case class EventsList(title: String,
            icon: String,
            events: List[Event] = List.empty) extends Component
