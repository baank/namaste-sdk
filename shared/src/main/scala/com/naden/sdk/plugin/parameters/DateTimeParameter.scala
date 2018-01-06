package com.naden.sdk.plugin.parameters

import java.time.LocalDateTime

import com.naden.sdk.plugin.parameters.DateTimeStyle.DateTimeStyle
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
    extends Parameter[LocalDateTime]

object DateTimeStyle extends Enumeration {
  type DateTimeStyle = Value
  val None = Value("-")
  val Short = Value("S")
  val Medium = Value("M")
  val Long = Value("L")
  val Full = Value("F")
}
