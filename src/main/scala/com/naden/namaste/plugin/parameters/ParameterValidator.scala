package com.naden.namaste.plugin.parameters

import java.util.Locale
import com.naden.namaste.plugin.util.LocalizationUtils.str

trait ParameterValidator {
  def invalid(item: Any): Option[String]
}

case class MinimumCharactersValidator(length: Int)(implicit locale: Locale)
    extends ParameterValidator {
  override def invalid(item: Any): Option[String] = item match {
    case s: String if s.length <= length =>
      Some(str(locale, "validation.minimumCharacters")) // TODO add length
    case _ => None
  }
}

case class MaximumCharactersValidator(length: Int)(implicit locale: Locale)
    extends ParameterValidator {
  override def invalid(item: Any): Option[String] = item match {
    case s: String if s.length > length =>
      Some(str(locale, "validation.maximumCharacters")) // TODO add length
    case _ => None
  }
}
