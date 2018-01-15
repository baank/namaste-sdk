package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Tag(createdBy: User,
               title: String)
    extends Object(createdBy)
