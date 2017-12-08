package com.naden.namaste.models

import java.time.LocalDateTime

import com.naden.namaste.models.PaymentStatus.PaymentStatus

case class Invoice(title: String,
                   createdBy: User,
                   description: String,
                   amount: Int,
                   recipient: String,
                   paymentStatus: PaymentStatus,
                   paymentMethod: PaymentStatus,
                   dueTime: LocalDateTime)
    extends Object(createdBy)

object PaymentMethod extends Enumeration {
  type PaymentMethod = Value
  val MASTERCARD = Value("Mastercard")
  val VISA = Value("Visa")
  val AMEX = Value("American Express")
  val DINERS = Value("Diner's Club")
  val PAYPAL = Value("Paypal")
  val BITCOIN = Value("Bitcoin")
  val CASH = Value("Cash")
  val MONEY_ORDER = Value("Money Order")
  val CHEQUE = Value("Cheque")
}

object PaymentStatus extends Enumeration {
  type PaymentStatus = Value
  val OVERDUE = Value("Overdue")
  val PENDING = Value("Pending")
  val PAID = Value("Paid")
  val ON_HOLD = Value("On Hold")
  val CANCELLED = Value("Cancelled")
}
