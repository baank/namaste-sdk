package com.naden.sdk.components.cards

import com.naden.sdk.models.{Component, Invoice}
import io.circe.generic.JsonCodec

@JsonCodec
case class InvoiceCard(invoice: Invoice,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
