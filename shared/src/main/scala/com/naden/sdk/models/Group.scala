package com.naden.sdk.models

case class Group(createdBy: User,
                 title: String,
                 users: Set[User] = Set.empty)
    extends Object(createdBy)