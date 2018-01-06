package com.naden.sdk.models

case class Tag(createdBy: User,
               title: String)
    extends Object(createdBy)
