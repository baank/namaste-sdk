package com.naden.namaste.models

case class User(firstName: String,
                lastName: String,
                preferredName: Option[String],
                emailAddress: String,
                title: String,
                createdBy: User,
                groups: Set[Group],
                thumbnail: String)
    extends Object(createdBy)

case class UserSocialNetwork()