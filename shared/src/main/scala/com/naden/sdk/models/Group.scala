package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Group(createdBy: Option[User],
                 title: String,
                 users: Set[User] = Set.empty)
    extends Entity with Serializable
