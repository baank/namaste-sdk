package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Video}
import io.circe.generic.JsonCodec

@JsonCodec
case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component
