package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Invoice(createdBy: User,
                   title: String,
                   description: String,
                   amount: Int,
                   recipient: String,
                   paymentStatus: PaymentStatus,
                   paymentMethod: PaymentMethod,
                   dueTime: LocalDateTime)
    extends Entity

@JsonCodec
sealed trait PaymentMethod
object PaymentMethod {
  case object Mastercard extends PaymentMethod
  case object Visa extends PaymentMethod
  case object Amex extends PaymentMethod
  case object Diners extends PaymentMethod
  case object Paypal extends PaymentMethod
  case object Bitcoin extends PaymentMethod
  case object Cash extends PaymentMethod
  case object MoneyOrder extends PaymentMethod
  case object Cheque extends PaymentMethod
}

@JsonCodec
sealed trait PaymentStatus
object PaymentStatus {
  case object Overdue extends PaymentStatus
  case object Pending extends PaymentStatus
  case object Paid extends PaymentStatus
  case object OnHold extends PaymentStatus
  case object Cancelled extends PaymentStatus
}
