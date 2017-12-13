package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.User

case class UserCard(user: User,
            showIcon: Boolean,
            showPosition: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean) extends Component