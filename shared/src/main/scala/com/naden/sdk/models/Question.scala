package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Question(createdBy: User,
                    title: String,
                    category: String,
                    body: String,
                    votes: Int)
    extends Object(createdBy)
