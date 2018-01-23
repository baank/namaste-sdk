package com.naden.sdk.models

import boopickle.Default._

case class Image(createdBy: User,
                 title: String,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 mimeType: String)
    extends Object(createdBy)


object Image {
	implicit val pickler: Pickler[Image] = generatePickler[Image]
}