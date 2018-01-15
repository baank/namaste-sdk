package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Image}
import io.circe.generic.JsonCodec

@JsonCodec
case class  ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component
