package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Video(createdBy: Option[User],
                 title: String,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 playTime: Int,
                 mimeType: String)
    extends Entity with Serializable
