package com.naden.namaste.models

case class Image(createdBy: User,
                 title: String,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 mimeType: String)
    extends Object(createdBy)
