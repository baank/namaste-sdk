package com.naden.sdk.models

import java.time.Instant
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._
import enumeratum._

@JsonCodec
case class Invoice(createdBy: Option[User],
                   title: String,
                   description: String,
                   amount: Int,
                   recipient: String,
                   paymentStatus: PaymentStatus,
                   paymentMethod: PaymentMethod,
                   dueTime: Instant)
    extends Entity with Serializable

sealed trait PaymentMethod extends EnumEntry
case object PaymentMethod extends Enum[PaymentMethod] with CirceEnum[PaymentMethod] {
  case object Mastercard extends PaymentMethod
  case object Visa extends PaymentMethod
  case object Amex extends PaymentMethod
  case object Diners extends PaymentMethod
  case object Paypal extends PaymentMethod
  case object Bitcoin extends PaymentMethod
  case object Cash extends PaymentMethod
  case object MoneyOrder extends PaymentMethod
  case object Cheque extends PaymentMethod
  val values = findValues
}

sealed trait PaymentStatus extends EnumEntry
case object PaymentStatus extends Enum[PaymentStatus] with CirceEnum[PaymentStatus] {
  case object Overdue extends PaymentStatus
  case object Pending extends PaymentStatus
  case object Paid extends PaymentStatus
  case object OnHold extends PaymentStatus
  case object Cancelled extends PaymentStatus
  val values = findValues
}
