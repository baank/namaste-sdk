package com.naden.namaste.models

case class Image(title: String,
                 createdBy: User,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 mimeType: String)
  extends Object(createdBy)