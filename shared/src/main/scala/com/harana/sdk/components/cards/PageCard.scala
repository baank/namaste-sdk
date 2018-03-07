package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Page}
import io.circe.generic.JsonCodec

@JsonCodec
case class PageCard(page: Page,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
