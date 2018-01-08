package com.naden.sdk.models

case class File(createdBy: User,
                title: String,
                description: String,
                fileName: String,
                fileSize: Double,
                mimeType: String)
    extends Object(createdBy)
