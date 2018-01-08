package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.Page

case class PageCard(page: Page,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
