package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class File(createdBy: User,
                title: String,
                description: String,
                fileName: String,
                fileSize: Double,
                mimeType: String)
    extends Entity
