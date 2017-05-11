package com.naden.namaste.models

case class Group(name: String,
                 createdBy: User,
                 users: Set[User] = Set.empty)
    extends Object(createdBy)
