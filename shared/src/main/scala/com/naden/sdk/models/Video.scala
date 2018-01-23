package com.naden.sdk.models

import boopickle.Default._

case class Video(createdBy: User,
                 title: String,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 playTime: Int,
                 mimeType: String)
    extends Object(createdBy)


object Video {
	implicit val pickler: Pickler[Video] = generatePickler[Video]
}