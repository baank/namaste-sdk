package com.naden.namaste.models

case class Tag(createdBy: User, name: String)
    extends Object(createdBy)
