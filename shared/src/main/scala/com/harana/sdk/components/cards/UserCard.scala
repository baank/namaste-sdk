package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, User}
import io.circe.generic.JsonCodec

@JsonCodec
case class UserCard(user: User,
            showIcon: Boolean,
            showPosition: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean) extends Component
