package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}
import com.naden.namaste.plugin.parameters.DateTimeStyle.DateTimeStyle
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class DateTimeParameter(key: String,
                             default: Option[DateTime] = None,
                             dateOptions: Seq[DateTime] = Seq(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short,
                             dateValidators: Seq[ParameterValidator])(implicit locale: Locale)
  extends LocalizedParameter[DateTime](key) {
  private val dateFormat = DateTimeFormat.forStyle(dateStyle.toString + timeStyle.toString)
  def options = dateOptions.map(d => (dateFormat.withLocale(locale).print(d), d))
  def validators = dateValidators
}

object DateTimeStyle extends Enumeration {
  type DateTimeStyle = Value
  val None = Value("-")
  val Short = Value("S")
  val Medium = Value("M")
  val Long = Value("L")
  val Full = Value("F")
}