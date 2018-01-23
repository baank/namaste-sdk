package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Component, User}

case class UsersList(title: String,
            icon: String,
            users: List[User],
            showPosition: Boolean,
            showOnline: Boolean,
            showMessenging: Boolean) extends Component


object UsersList {
	implicit val pickler: Pickler[UsersList] = generatePickler[UsersList]
}