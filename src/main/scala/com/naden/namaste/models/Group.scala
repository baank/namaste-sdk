package com.naden.namaste.models

case class Group(name: String,
                 createdBy: Option[User],
                 users: Set[User] = Set.empty)
    extends Object(createdBy)
