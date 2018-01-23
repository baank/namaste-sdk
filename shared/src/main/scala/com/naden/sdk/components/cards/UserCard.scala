package com.naden.sdk.components.cards

import boopickle.Default._

import com.naden.sdk.models.{Component, User}

case class UserCard(user: User,
            showIcon: Boolean,
            showPosition: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean) extends Component


object UserCard {
	implicit val pickler: Pickler[UserCard] = generatePickler[UserCard]
}