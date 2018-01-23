package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Component, Event}

case class EventsList(title: String,
            icon: String,
            events: List[Event] = List.empty) extends Component


object EventsList {
	implicit val pickler: Pickler[EventsList] = generatePickler[EventsList]
}