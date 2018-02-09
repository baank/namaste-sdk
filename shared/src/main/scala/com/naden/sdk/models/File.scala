package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class File(createdBy: Option[User],
                title: String,
                description: String,
                fileName: String,
                fileSize: Double,
                mimeType: String)
    extends Entity with Serializable
