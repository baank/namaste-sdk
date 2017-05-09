package com.naden.namaste.models

case class Event(name: String, createdBy: Option[User])
    extends Object(createdBy)
