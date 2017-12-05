package com.naden.namaste.plugin.parametervalidators

import com.naden.namaste.plugin.ParameterValidator

case class MinimumCharactersValidator(length: Int)()
    extends ParameterValidator {
  override def invalid(item: Any): Option[String] = item match {
    case s: String if s.length <= length =>
      Some("validation.minimumCharacters") // TODO add length
    case _ => None
  }
}
