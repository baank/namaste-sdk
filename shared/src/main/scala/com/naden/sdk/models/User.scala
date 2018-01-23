package com.naden.sdk.models

import boopickle.Default._

case class User(createdBy: User,
                firstName: String,
                lastName: String,
                preferredName: Option[String],
                emailAddress: String,
                title: Option[String],
                groups: Set[Group],
                thumbnail: Option[String])
    extends Object(createdBy)

object User {
	implicit val pickler: Pickler[User] = generatePickler[User]
}