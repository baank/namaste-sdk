package com.harana.sdk.components.cards

import com.harana.sdk.models.{Component, Invoice}
import io.circe.generic.JsonCodec

@JsonCodec
case class InvoiceCard(invoice: Invoice,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component
