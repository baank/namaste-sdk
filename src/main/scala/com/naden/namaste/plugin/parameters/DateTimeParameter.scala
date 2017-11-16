package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.parameters.DateTimeStyle.DateTimeStyle
import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}
import org.joda.time.DateTime

case class DateTimeParameter(key: String,
                             default: Option[DateTime] = None,
                             dateOptions: Seq[DateTime] = Seq(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short,
                             validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[DateTime](key)

object DateTimeStyle extends Enumeration {
  type DateTimeStyle = Value
  val None = Value("-")
  val Short = Value("S")
  val Medium = Value("M")
  val Long = Value("L")
  val Full = Value("F")
}