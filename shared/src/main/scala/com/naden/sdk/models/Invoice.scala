package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.Invoice.InvoiceId
import com.naden.sdk.models.User.UserId
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
                   createdBy: Option[UserId],
                   createdTime: Instant,
                   updatedBy: Option[UserId],
                   updatedTime: Instant,
                   id: Option[InvoiceId],
                   status: Status,
                   version: Long,
                   relationships: Map[String, EntityId])
    extends Entity with Serializable {

  type EntityType = Invoice
  def copyId(newId: UUID) = copy(id = Some(newId))
  def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
  def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object Invoice {
  type InvoiceId = UUID

  def apply(title: String, description: String, amount: Money, recipient: String, paymentStatus: PaymentStatus, paymentMethod: PaymentMethod, dueTime: Instant, createdBy: User): Invoice = {
    apply(title, description, amount, recipient, paymentStatus, paymentMethod, dueTime, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
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
