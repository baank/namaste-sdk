package com.naden.namaste.plugin.parametervalidators

import java.util.Locale
import com.naden.namaste.plugin.util.LocalizationUtils.str
import com.naden.namaste.plugin.ParameterValidator

case class MaximumCharactersValidator(length: Int)(implicit locale: Locale)
    extends ParameterValidator {
  override def invalid(item: Any): Option[String] = item match {
    case s: String if s.length > length =>
      Some(str(locale, "validation.maximumCharacters")) // TODO add length
    case _ => None
  }
}