package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class User(createdBy: User,
                firstName: String,
                lastName: String,
                preferredName: Option[String],
                emailAddress: String,
                title: Option[String],
                groups: Set[Group],
                thumbnail: Option[String])
    extends Object(createdBy)