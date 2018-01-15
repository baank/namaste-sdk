package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Video(createdBy: User,
                 title: String,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 playTime: Int,
                 mimeType: String)
    extends Object(createdBy)
