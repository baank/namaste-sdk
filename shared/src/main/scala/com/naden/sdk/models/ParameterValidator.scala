package com.naden.sdk.models

import boopickle.Default._

sealed trait ParameterValidator
object ParameterValidator {
  case object MinimumCharactersValidator extends ParameterValidator
}
