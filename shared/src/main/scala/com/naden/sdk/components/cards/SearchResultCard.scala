package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, User}
import io.circe.generic.JsonCodec

@JsonCodec
case class SearchResultCard(user: User,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
