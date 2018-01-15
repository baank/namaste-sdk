package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Video}
import io.circe.generic.JsonCodec

@JsonCodec
case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component
