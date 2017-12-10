package com.naden.namaste.models

case class Tag(createdBy: User,
               title: String)
    extends Object(createdBy)
