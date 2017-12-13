package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Video

case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component