package com.naden.namaste.plugin.parametervalidators

import java.util.Locale

import com.naden.namaste.plugin.ParameterValidator

case class MinimumCharactersValidator(length: Int)(implicit locale: Locale)
    extends ParameterValidator {
  override def invalid(item: Any): Option[String] = item match {
    case s: String if s.length <= length =>
      Some(str(locale, "validation.minimumCharacters")) // TODO add length
    case _ => None
  }
}
