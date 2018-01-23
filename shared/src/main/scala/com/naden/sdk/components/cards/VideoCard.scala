package com.naden.sdk.components.cards

import boopickle.Default._

import com.naden.sdk.models.{Component, Video}

case class VideoCard(video: Video,
            showTitle: Boolean,
            showDescription: Boolean,
            showPlayTime: Boolean,
            showDownload: Boolean) extends Component


object VideoCard {
	implicit val pickler: Pickler[VideoCard] = generatePickler[VideoCard]
}