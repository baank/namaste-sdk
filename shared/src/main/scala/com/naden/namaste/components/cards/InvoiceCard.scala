package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.User

case class InvoiceCard(user: User,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component