package com.naden.sdk.plugin.parameters

import java.time.LocalDateTime

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class DateTimeParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[LocalDateTime] = None,
                             dateOptions: Seq[LocalDateTime] = Seq(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short,
                             validators: Seq[ParameterValidator] = Seq())()
    extends Parameter

sealed trait DateTimeStyle
object DateTimeStyle {
  case object None extends DateTimeStyle
  case object Short extends DateTimeStyle
  case object Medium extends DateTimeStyle
  case object Long extends DateTimeStyle
  case object Full extends DateTimeStyle
}