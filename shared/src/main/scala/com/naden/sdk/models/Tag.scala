package com.naden.sdk.models

import boopickle.Default._

case class Tag(createdBy: User,
               title: String)
    extends Object(createdBy)


object Tag {
	implicit val pickler: Pickler[Tag] = generatePickler[Tag]
}