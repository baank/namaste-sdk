package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Page}
import io.circe.generic.JsonCodec

@JsonCodec
case class PageCard(page: Page,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
