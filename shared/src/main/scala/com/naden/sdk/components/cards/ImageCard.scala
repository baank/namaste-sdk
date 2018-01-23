package com.naden.sdk.components.cards

import boopickle.Default._

import com.naden.sdk.models.{Component, Image}

case class  ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component


object  ImageCard {
	implicit val pickler: Pickler[ ImageCard] = generatePickler[ ImageCard]
}