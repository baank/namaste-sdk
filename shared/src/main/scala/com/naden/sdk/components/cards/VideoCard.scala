package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.Video

case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component
