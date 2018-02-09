package com.naden.sdk.models

import enumeratum._

sealed trait ParameterValidator extends EnumEntry
case object ParameterValidator extends Enum[ParameterValidator] with CirceEnum[ParameterValidator] {
  case object MinimumCharactersValidator extends ParameterValidator with Serializable
  val values = findValues
}
