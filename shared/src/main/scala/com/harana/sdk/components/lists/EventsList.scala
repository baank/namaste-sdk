package com.harana.sdk.components.lists

import com.harana.sdk.models.{Component, Event}
import io.circe.generic.JsonCodec

@JsonCodec
case class EventsList(title: String,
            icon: String,
            events: List[Event] = List.empty) extends Component
