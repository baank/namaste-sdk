package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._
import enumeratum._
import squants.Money

@JsonCodec
case class Invoice(title: String,
                   description: String,
                   amount: Money,
                   recipient: String,
                   paymentStatus: PaymentStatus,
                   paymentMethod: PaymentMethod,
                   dueTime: Instant,
                   createdBy: Option[UUID],
                   createdTime: Instant,
                   updatedBy: Option[UUID],
                   updatedTime: Instant,
                   guid: Option[UUID],
                   status: Status,
                   version: Long,
                   relationships: Map[String, UUID])
    extends Entity with Serializable {

  type EntityType = Invoice
  def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
  def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
  def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Invoice {
  def apply(title: String, description: String, amount: Money, recipient: String, paymentStatus: PaymentStatus, paymentMethod: PaymentMethod, dueTime: Instant, createdBy: User): Invoice = {
    apply(title, description, amount, recipient, paymentStatus, paymentMethod, dueTime, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
  }
}

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
