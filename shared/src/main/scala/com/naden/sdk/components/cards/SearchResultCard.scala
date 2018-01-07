package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.User
import boopickle.Default._

case class SearchResultCard(user: User,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
