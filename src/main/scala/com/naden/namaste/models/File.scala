package com.naden.namaste.models

case class File(title: String,
                createdBy: User,
                description: String,
                fileName: String,
                fileSize: Double,
                mimeType: String)
  extends Object(createdBy)