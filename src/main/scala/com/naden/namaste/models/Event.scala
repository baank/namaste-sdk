package com.naden.namaste.models

case class Event(name: String, createdBy: User)
    extends Object(createdBy)
