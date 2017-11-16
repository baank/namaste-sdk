package com.naden.namaste.ui.models.cards

import com.naden.namaste.models.User

case class UserCard(user: User,
                    showTitle: Boolean,
                    showSocial: Boolean,
                    showMessaging: Boolean,
                    value: String)
