package com.naden.sdk.models
import boopickle.Default._

case class File(createdBy: User,
                title: String,
                description: String,
                fileName: String,
                fileSize: Double,
                mimeType: String)
    extends Object(createdBy)
