package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
sealed trait ParameterValidator
object ParameterValidator {
  case object MinimumCharactersValidator extends ParameterValidator
}
