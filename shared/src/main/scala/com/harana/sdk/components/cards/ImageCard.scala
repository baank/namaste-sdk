package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Image}
import io.circe.generic.JsonCodec

@JsonCodec
case class  ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component
