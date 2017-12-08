package com.naden.namaste.models

case class Group(createdBy: User, name: String, users: Set[User] = Set.empty)
    extends Object(createdBy)
