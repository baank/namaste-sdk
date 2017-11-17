package com.naden.namaste.ui.models.cards

import com.naden.namaste.models.Video

case class VideoCard(video: Video,
                     showTitle: Boolean,
                     showDescription: Boolean,
                     showPlayTime: Boolean,
                     showDownload: Boolean)
