package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Tag(createdBy: Option[User],
               title: String)
    extends Entity with Serializable
