package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.Event

case class EventsList(title: String,
                      icon: String,
                      events: List[Event])