package com.naden.namaste.ui.models.cards

import com.naden.namaste.models.User

case class SearchResultCard(user: User,
                            showTitle: Boolean,
                            showSocial: Boolean,
                            showMessaging: Boolean,
                            value: String)
