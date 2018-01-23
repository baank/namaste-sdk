package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Component, Image}

case class ImagesList(title: String,
                      icon: String,
                      images: List[Image] = List.empty,
                      columns: Int) extends Component


object ImagesList {
	implicit val pickler: Pickler[ImagesList] = generatePickler[ImagesList]
}