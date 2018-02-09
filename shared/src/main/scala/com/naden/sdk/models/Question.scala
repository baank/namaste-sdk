package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Question(createdBy: Option[User],
                    title: String,
                    category: String,
                    body: String,
                    votes: Int)
    extends Entity with Serializable
