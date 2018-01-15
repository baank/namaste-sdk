package com.naden.sdk.components.lists

import com.naden.sdk.models.{Component, User}
import io.circe.generic.JsonCodec

@JsonCodec
case class UsersList(title: String,
            icon: String,
            users: List[User],
            showPosition: Boolean,
            showOnline: Boolean,
            showMessenging: Boolean) extends Component
