package com.naden.namaste.plugin

import java.util.Locale

import com.naden.namaste.plugin.DateTimeStyle.DateTimeStyle
import com.naden.namaste.plugin.util.Localized
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

trait Parameter[T] extends Localized {
  def key(implicit locale: Locale): String = str(locale, s"$key.name")
  def description(implicit locale: Locale): String = str(locale, s"$key.description")
  def default(implicit locale: Locale): Option[T]
  def group(implicit locale: Locale): Option[String] = Option(str(locale, s"$key.group"))
  def options(implicit locale: Locale): Seq[(String, T)]
  def validators: Set[ParameterValidator] = Set.empty[ParameterValidator]
}

case class StringParameter(key: String, default: Option[String], optionKeys: Seq[String])(
    implicit locale: Locale)
    extends Parameter[String] {
  def options = optionKeys.map(o => str(locale, s"$key.parameter.$o"))
}

case class BooleanParameter(key: String, booleanDefault: Boolean) extends Parameter[Boolean] {
  def options = None
  def default = Option(booleanDefault)
}

case class NumberParameter[A](key: String,
                              default: Option[A],
                              numberOptions: Seq[A],
                              validators: Set[ParameterValidator])(implicit num: Numeric[A])
    extends Parameter[A] {
  def options = numberOptions.map(n => (n.toString, n))
}

case class DateTimeParameter(key: String,
                             default: Option[DateTime],
                             dateOptions: Seq[DateTime],
                             dateStyle: DateTimeStyle,
                             timeStyle: DateTimeStyle,
                             validators: Set[ParameterValidator])(implicit locale: Locale)
    extends Parameter[DateTime] {
  private val dateFormat = DateTimeFormat.forStyle(dateStyle.toString + timeStyle.toString)
  def options = dateOptions.map(d => (dateFormat.withLocale(locale).print(d), d))
}

object DateTimeStyle extends Enumeration {
  type DateTimeStyle = Value
  val None = Value("-")
  val Short = Value("S")
  val Medium = Value("M")
  val Long = Value("L")
  val Full = Value("F")
}
