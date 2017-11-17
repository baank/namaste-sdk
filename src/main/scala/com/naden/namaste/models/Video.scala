package com.naden.namaste.models

case class Video(title: String,
                 createdBy: User,
                 description: String,
                 fileName: String,
                 fileSize: Double,
                 width: Int,
                 height: Int,
                 playTime: Int,
                 mimeType: String)
  extends Object(createdBy)