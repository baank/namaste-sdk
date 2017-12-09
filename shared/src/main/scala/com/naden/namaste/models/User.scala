package com.naden.namaste.models

case class User(createdBy: User,
                firstName: String,
                lastName: String,
                preferredName: Option[String],
                emailAddress: String,
                title: String,
                groups: Set[Group],
                thumbnail: String)
    extends Object(createdBy)

case class UserSocialNetwork()