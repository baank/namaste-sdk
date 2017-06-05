package com.naden.namaste.plugin

import java.util.Locale

import com.naden.namaste.plugin.DateTimeStyle.DateTimeStyle
import com.naden.namaste.plugin.util.LocalizationUtils.str
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

trait Parameter[T] {
  def name: String
  def description: String
  def default: Option[T]
  def group: Option[String]
  def options: Seq[(String, T)]
  def validators: Seq[ParameterValidator]
}

abstract class LocalizedParameter[T](key: String)(implicit locale: Locale) extends Parameter[T] {
  def name: String = str(locale, s"$key.name")
  def description: String = str(locale, s"$key.description")
  def group: Option[String] = Option(str(locale, s"$key.group"))
}

case class StringParameter(key: String,
                           default: Option[String],
                           optionKeys: Seq[String],
                           stringValidators: Seq[ParameterValidator])(implicit locale: Locale)
    extends LocalizedParameter[String](key) {
  def options = optionKeys.map(o => (str(locale, s"$key.parameter.$o"), o))
  def validators = stringValidators
}

case class BooleanParameter(key: String, booleanDefault: Boolean)(implicit locale: Locale)
    extends LocalizedParameter[Boolean](key) {
  def options = Seq.empty
  def default = Option(booleanDefault)
  def validators = Seq.empty[ParameterValidator]
}

case class NumberParameter[A](
    key: String,
    default: Option[A],
    numberOptions: Seq[A],
    numberValidators: Seq[ParameterValidator])(implicit num: Numeric[A], locale: Locale)
    extends LocalizedParameter[A](key) {
  def options = numberOptions.map(n => (n.toString, n))
  def validators = numberValidators
}

case class DateTimeParameter(key: String,
                             default: Option[DateTime],
                             dateOptions: Seq[DateTime],
                             dateStyle: DateTimeStyle,
                             timeStyle: DateTimeStyle,
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
